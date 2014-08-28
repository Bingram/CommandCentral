package com.android.jblm.commandcentral;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.android.jblm.commandcentral.adapters.HeaderAdapter;
import com.android.jblm.commandcentral.objects.Category;
import com.android.jblm.commandcentral.objects.Contact;

import java.util.HashMap;

/**
 * Created by Brian 2014.
 *
 * Displays the current category's list of contacts.
 * Uses the call back method to the Phone Book Activity that created it
 * The phone book activity implements the interface in order to return the list of contacts
 *
 * This list fragment uses the Header Adapter to create the views for each item in the list.
 *
 *
 */
public class ContactListFragment extends ListFragment {

    OnContactSelectedListener mCallBack;//call back to parent Activity
    Contact[] contacts;//List of contacts for current category

    // Container Activity must implement this interface
    public interface OnContactSelectedListener {
        //action on contact selection
        public void onContactSelected(Contact c);
        //get current category
        public Category getCurCategory();
        //get hash map of contacts
        public HashMap<String, Contact[]> getMyContacts();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //get list of contacts from parent activity
        //using current category title as key from hash map
        contacts = mCallBack.getMyContacts()
                .get(mCallBack.getCurCategory().getTitle());

        // Populate list with list of contacts
        setListAdapter(new HeaderAdapter(getActivity(), contacts));
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    /**
     * Assign the call back activity to parent activity this fragment is attached to
     * ...on attach
     * @param activity Parent activity calling fragment
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallBack = (OnContactSelectedListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeaderSelectedListener");
        }
    }

    /**
     * Clears the call back activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }

    /**
     * List view fragment controls what hapens on item select, position is sent back to
     * parent activity to method for execution.
     * @param l
     * @param v
     * @param position
     * @param id
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Send the parent activity the contact selected
        mCallBack.onContactSelected(contacts[position]);


        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);

    }

}
