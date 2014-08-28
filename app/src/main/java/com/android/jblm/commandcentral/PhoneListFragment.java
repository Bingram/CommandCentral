package com.android.jblm.commandcentral;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.android.jblm.commandcentral.adapters.PhoneAdapter;

import java.util.List;

/**
 * Created by Brian 2014.
 *
 * Displays the current contacts list of phone numbers.
 * Uses the call back method to the Phone Book Activity that created it
 * The phone book activity implements the interface in order to return the list of numbers
 *
 * This list fragment uses the Phone Adapter to create the views for each item in the list.
 *
 *
 */
public class PhoneListFragment extends ListFragment {

    List<String> list;//list of phone numbers
    ContactFragment.getContactListener mCallBack;//call back to parent Activity

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //get list of numbers from current contact
        //by calling back to parent activity
        list = mCallBack.getCurContact().phoneNumbers;

        // Populate list with our static array of phone numbers.
        setListAdapter(new PhoneAdapter(getActivity(), list));
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

            mCallBack = (ContactFragment.getContactListener) activity;

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

}
