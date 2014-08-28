package com.android.jblm.commandcentral.generators;

import com.android.jblm.commandcentral.objects.Post;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian 2014.
 *
 * Iterates over XML file from web source using XMLPullParser
 */
public class NewsBuilder {

    //Web address of XML/RSS feed source
    private static final String xmlUrl = "http://www.nwguardian.com/100/v-highlights/index.rss";

    private List<Post> thePosts;

    public NewsBuilder(){

        thePosts = new ArrayList<Post>();

        buildBook();

    }

    /**
     * building the book from the XML source
     * @return
     */
    public int buildBook(){

        Post thePost = new Post();//working post, gets renewed at end tag

        int event;
        try{
            URL url = new URL(xmlUrl);
            HttpURLConnection conn = (HttpURLConnection)
                    url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            InputStream stream = conn.getInputStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(stream, null);

            event = xpp.getEventType();

            String type = "";
            String flag = "";

            //while there is still tags left
            while (event != XmlPullParser.END_DOCUMENT) {

                //checks for start tag and then sets matching flag for TEXT event
                if(event == XmlPullParser.START_TAG){

                    if(xpp.getName().equals("item") && flag.equals("post")){


                    } else if(xpp.getName().equals("managingEditor")){

                        flag = "post";
                    } else if(xpp.getName().equals("title") && flag.equals("post")){

                        type = "title";
                    } else if (xpp.getName().equals("link") && flag.equals("post")){
                        type = "link";

                    } else if (xpp.getName().equals("pubDate") && flag.equals("post")){
                        type = "pubDate";

                    } else if (xpp.getName().equals("description") && flag.equals("post")){
                        type = "description";

                    }
                } else if(event == XmlPullParser.TEXT && flag.equals("post")) {

                    //filter out blank lines between tags
                    if(!xpp.getText().replaceAll("[^A-Za-z0-9]", "").equals("")){

                        if(type.equals("item")){

                        } else if(type.equals("title")){//set working post title

                            //filters out the new line char and tab char, but leaves other symbols
                            String post_title = xpp.getText().replaceAll("[\n,\t]", "");
                            thePost.setPostTitle(post_title);

                        } else if (type.equals("link")){//set working post url
                            thePost.setPostURL(xpp.getText());

                        } else if (type.equals("pubDate")){//set working post date
                            thePost.setPostDate(xpp.getText());

                        } else if (type.equals("description")){//set working post description
                            thePost.setPostDesc(xpp.getText());

                        }
                    }

                } else if (event == XmlPullParser.END_TAG){
                    //close of post item, add to list
                    if (xpp.getName().equals("item")){//done with current post

                        thePosts.add(thePost);//add working post to list
                        thePost = new Post();//renew/reset the working post
                    }


                }

                event = xpp.next();//get next tag event while there are still any


            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;//failed build
        }


        return 1;//successful build

    }

    /**
     * Getter for builders list of Posts
     * @return List<Post> list of posts
     */
    public List<Post> getThePosts() {

        return thePosts;
    }
}
