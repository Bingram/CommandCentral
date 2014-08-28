package com.android.jblm.commandcentral.generators;

import android.content.Context;

import com.android.jblm.commandcentral.R;
import com.android.jblm.commandcentral.objects.Category;
import com.android.jblm.commandcentral.objects.Contact;
import com.android.jblm.commandcentral.objects.Directory;
import com.android.jblm.commandcentral.objects.Header;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Brian 2014.
 *
 * Currently builds a Directory object by iterating a local file XML file in the raw folder.
 * The original idea is to have the builder check for a file, and compare the date listed inside
 * to current date and force and update after 30 days. the date tag broke the file and read/write
 * involving raw folder was not feasible in time.
 */
public class DirectoryBuilder {

    private Directory book;//book builder is making

    private Context myContext;//activity that called this builder

    //planned usage for keeping persistent serialized copy of 'book'
    //to avoid recreating it ever time, for now too complex
    private static Boolean makeFile = false;

    public DirectoryBuilder(Context c){
        myContext = c;
        makeFile = true;
        book = new Directory();
        buildBook();
    }

    /*public DirectoryBuilder(Directory theBook){
        book = theBook;
    }*/

    /**
     * Getter for the Directroy object built
     * @return
     */
    public Directory getBook() {
        return book;
    }

    //Currently the buildbook does not check for file existence or age
    //I wasn't sure where to put the "freshness" check for the XML information online v. local

    public  void buildBook() {

        //previous check for local file
        if(makeFile){
            try {

                XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = xppf.newPullParser();
                xppf.setNamespaceAware(true);

                //See Android Developer website for raw resources to access/modify directory file
                InputStream fis = myContext.getResources().openRawResource(R.raw.jblmappdirectoryfile);

                xpp.setInput(fis, null);
                int type = xpp.getEventType();
                String flag = "";

                Header curHeader = new Header();//current working header
                Category curCategory = new Category();//current working category
                Contact curContact = new Contact();//current working contact

                //While document still has unread tags
                while(type != XmlPullParser.END_DOCUMENT) {


                    //Set the flag for TEXT event section
                    if(type == XmlPullParser.START_TAG) {
                        if(xpp.getName().equals("Header")){
                            flag = "Header";
                        } else if(xpp.getName().equals("Category")){
                            flag = "Category";
                        } else if(xpp.getName().equals("Contact")){
                            curContact = new Contact();
                        } else if(xpp.getName().equals("Name")){
                            flag = "Name";
                        } else if(xpp.getName().equals("Phone")){
                            flag = "Phone";
                        } else if(xpp.getName().equals("URL")){
                            flag = "URL";
                        } else if(xpp.getName().equals("Email")){
                            flag = "Email";
                        } else if(xpp.getName().equals("Description")){
                            flag = "Description";
                        }
                    } else if(type == XmlPullParser.TEXT) {

                        //Filter for blank lines bewtween tags
                        if(!xpp.getText().replaceAll("[^A-Za-z0-9]", "").equals("")){

                            if(flag.equals("Header")){//create new header on start tag
                                curHeader = new Header(xpp.getText().replaceAll("[^A-Za-z0-9]", ""));
                            }else if(flag.equals("Category")){//Create new category on start tag
                                curCategory = new Category(xpp.getText().replaceAll("[^A-Za-z0-9]", ""));
                            } else if(flag.equals("Name")){//add contact name
                                curContact.contactName = xpp.getText();
                            } else if(flag.equals("Phone")){//add contact phone number to list
                                curContact.addNumber(xpp.getText());
                            } else if(flag.equals("URL")){//add contact URL
                                curContact.contactURL = xpp.getText();
                            } else if(flag.equals("Email")){//add contact email address
                                curContact.contactEmail = xpp.getText();
                            } else if(flag.equals("Description")){//add contact description
                                curContact.contactDesc = xpp.getText();
                            }

                        }



                    } else if(type == XmlPullParser.END_TAG) {

                        if(xpp.getName().equals("Header")){//add current header to list
                            book.addHeader(curHeader);
                        }else if(xpp.getName().equals("Category")){
                            curHeader.addCategory(curCategory);//add current category to current header
                        } else if(xpp.getName().equals("Contact")){//add current contact to current category
                            curCategory.addContact(curContact);

                        }

                    }


                    type = xpp.next();
                }


            }
            catch (XmlPullParserException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


}
