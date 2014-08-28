package com.android.jblm.commandcentral;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.android.jblm.commandcentral.adapters.HeaderAdapter;
import com.android.jblm.commandcentral.objects.Header;

/**
 * Created by Brian 2014.
 *
 * Displays the header of phone book
 * Uses the call back method to the Phone Book Activity that created it
 * The phone book activity implements the interface in order to return the list of headers
 *
 * This list fragment uses the Header Adapter to create the views for each item in the list.
 *
 *
 */
public class HeaderListFragment extends ListFragment {

    private OnHeaderSelectedListener mCallBack;//callback to parent activity
    private  Header[] theHeaders = new Header[0];//array of header objects fro phone book

    // Container Activity must implement this interface
    public interface OnHeaderSelectedListener {
        public void onHeaderSelected(int position);
        public Header[] getMyHeaders();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //get headers from parent activity
        theHeaders = mCallBack.getMyHeaders();

        // Populate list with our static array of myHeaders.
        setListAdapter(new HeaderAdapter(getActivity(), theHeaders));

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
            mCallBack = (OnHeaderSelectedListener) activity;

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
        //send the parent activity the position of selected header
        mCallBack.onHeaderSelected(position);

        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);

    }

}
