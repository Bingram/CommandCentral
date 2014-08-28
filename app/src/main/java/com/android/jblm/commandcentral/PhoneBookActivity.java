package com.android.jblm.commandcentral;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.android.jblm.commandcentral.generators.DirectoryBuilder;
import com.android.jblm.commandcentral.objects.Category;
import com.android.jblm.commandcentral.objects.Contact;
import com.android.jblm.commandcentral.objects.Directory;
import com.android.jblm.commandcentral.objects.Header;

import java.util.HashMap;

/**
 * Phone book activty to display the fragments that make up the different layers of the phone book
 * First fragment to be displayed is the Header list, after that on selection of a header
 * its list of corresponding categories is added to another fragment which is replaced for the
 * header list fragment, After that a selection of a category, repeats the process but with a list
 * of contacts that fall under a category. Then a contact fragment is created on selection of a
 * contact and swapped for the contact list, at which point you can view the contact information.
 *
 * The contact fragment can call the parent activity once more with the phone number list fragment,
 * on pressing the button the phone list is sent back and displayed in a new fragment as the others.
 */
public class PhoneBookActivity extends FragmentActivity implements
        HeaderListFragment.OnHeaderSelectedListener,
        SubHeaderFragment.OnSubHeaderSelectedListener,
        ContactListFragment.OnContactSelectedListener,
        ContactFragment.getContactListener{

    private DirectoryBuilder builder;//directtory builder
    private Directory myBook;//book from builder

    private int selectedHeaderPos = 0;//currently selected header position
    private int selectedCategoryPos = 0;//currently selected sub header category position
    private int selectedContactPos = 0;

    private  Header[] myHeaders;//headers for main page of phone directory
    private  Category curCategory;//current sub category being viewed
    private Contact curContact;//current contact being viewed
    private  HashMap<String, Category[]> myCategories;//sub categories for each header
    private  HashMap<String, Contact[]> myContacts;//contact list under each category

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if(findViewById(R.id.fragment_container) != null){

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            //the builder for the phone directory
            builder = new DirectoryBuilder(this);

            //pass completed phone book to setup method
            setupBook(builder.getBook());

            //first fragment to be displayed in phone book activity
            HeaderListFragment firstFragment = new HeaderListFragment();

            //support fragment manager is called to begin managing fragments
            //header list fragment is added to manager and displayed on commit
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();


        }

    }

    /**
     *
     * @param theBook
     */
    private void setupBook(Directory theBook) {

        myBook = theBook;
        myHeaders = myBook.getHeaders();
        myCategories = new HashMap<String, Category[]>();
        myContacts = new HashMap<String, Contact[]>();

        //for-each through all the headers from the book
        for(Header h: myHeaders){
            //add category array with header name as key to hash map
            myCategories.put(h.getName(), h.getCategories());

            //for-each over each contact in category
            for(Category c: h.getCategories()){
                //add contact array with category name as key to hash map
                myContacts.put(c.getTitle(), c.getContacts());
            }

        }
    }

    /**
     * When a header is selected its position is passed in.
     * The position is set for current header selected and sub header fragment is
     * created to display list of categories for current header.
     * @param position int location of selected header
     */
    @Override
    public void onHeaderSelected(int position) {
        selectedHeaderPos = position;

        // The user selected the header from the HeaderListFragment


        // Create fragment for the chosen sub header list
        SubHeaderFragment newFragment = new SubHeaderFragment();

        //begin a new transaction on the fragment manager to add and display new fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();


    }

    /**
     * When a sub header is selected the position and corresponding category are passed in.
     * A new contact list fragment is created for the categories list of contacts.
     * A fragment transaction occurs the and the new fragment is swapped for the new one
     * @param position
     * @param cat
     */
    @Override
    public void onSubHeaderSelected(int position, Category cat) {
        selectedCategoryPos = position;
        curCategory = cat;
        // The user selected the sub header from the SubHeaderListFragment

        // Create fragment for the chosen contact list
        ContactListFragment newFragment = new ContactListFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

    }

    /**
     * When a contact is selected from the current category's list of contacts the contact is
     * passed in. A fragment is created for the contact fragment to be displayed, it is swapped
     * with the current sub header category list of contacts.
     * @param c
     */
    @Override
    public void onContactSelected(Contact c) {
        curContact = c;

        // Create fragment for the chosen contact to display
        ContactFragment newFragment = new ContactFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    /**
     * Getter for current headers.
     * @return Header[] of current headers
     */
    @Override
    public Header[] getMyHeaders() {
        return myHeaders;
    }

    /**
     * Getter for the position of currently selected header
     * @return int position of current header
     */
    @Override
    public int getSelectedHeaderPos() {
        return selectedHeaderPos;
    }

    /**
     * Getter for position of the currently selected sub header
     * @return int position of selected category
     */
    public int getSelectedCategoryPos() {
        return selectedCategoryPos;
    }

    /**
     * Getter for contact currently selected
     * @return Contact current contact
     */
    public Contact getCurContact() {
        return curContact;
    }

    /**
     * When a contact is displayed and the phone list button is hit, a new fragment is created
     * to display the list view of phone numbers for the current contact.
     */
    @Override
    public void showPhoneList() {
        // Create fragment for the chosen contacts phone number list
        PhoneListFragment newFragment = new PhoneListFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    /**
     * Getter for current selected sub header category
     * @return Category current category
     */
    public Category getCurCategory() {
        return curCategory;
    }

    /**
     * Getter for category Hash Map
     * String is sub header name for key
     * value is Category array for corresponding sub header
     * @return HashMap of Header name, Category[] pairs
     */
    @Override
    public HashMap<String, Category[]> getMyCategories() {
        return myCategories;
    }

    /**
     * Getter for contact Hash Map
     * String is sub header category name for key
     * value is Contact array for corresponding current category
     * @return HashMap of Category name, Contact[] pairs
     */
    @Override
    public HashMap<String, Contact[]> getMyContacts() {
        return myContacts;
    }



    //implement builder as asynchrnous task is best but doing so created broken list
    //will be necessary for getting an updated copy of list in future iterations
    //see the news builder for getting the XML source from web, but maybe check for
    //a local copy first and some way to check its "freshness"
    /**
     * Asynchronous inner class that handles building phone book in separate thread
     * onPostExecute is called when post thread completes, passing the list
     * back to the method setupListView
    class InnerDirectoryBuilder extends AsyncTask<String, Integer, Directory> {


        protected Directory doInBackground(String... params) {

            Log.w("DirectoryBuilder", "building book");
            //builder = new DirectoryBuilder();


            Log.w("DirectoryBuilder", "book built");
            return builder.getBook();
        }

        @Override
        protected void onPostExecute(Directory result){
            Log.w("DirectoryBuilder", "sending book");
            setupBook(result);

        }

        @Override
        protected void onProgressUpdate(Integer... values){

            //Nothing, used to show progress of building book
        }
    }*/
}
