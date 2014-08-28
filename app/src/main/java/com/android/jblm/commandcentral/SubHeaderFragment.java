package com.android.jblm.commandcentral;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.android.jblm.commandcentral.adapters.HeaderAdapter;
import com.android.jblm.commandcentral.objects.Category;
import com.android.jblm.commandcentral.objects.Header;

import java.util.HashMap;

/**
 * Created by Brian 2014.
 *
 * Displays the current headers's list of categories.
 * Uses the call back method to the Phone Book Activity that created it
 * The phone book activity implements the interface in order to return the list of categories
 *
 * This list fragment uses the Header Adapter to create the views for each item in the list.
 *
 *
 */
public class SubHeaderFragment extends ListFragment {

    OnSubHeaderSelectedListener mCallBack;//call back to parent activity
    Category[] categories = new Category[0];//array of categories

    // Container Activity must implement this interface
    public interface OnSubHeaderSelectedListener {
        public void onSubHeaderSelected(int position, Category categories);
        public int getSelectedHeaderPos();
        public HashMap<String, Category[]> getMyCategories();
        public Header[] getMyHeaders();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        int pos = mCallBack.getSelectedHeaderPos();//get position of selected header from list
        String headerName = mCallBack.getMyHeaders()[pos].getName();//get the header name at position

        /*
        Log.w("SubHeaderFragment", "Header List Pos " + pos + " Selected");
        Log.w("SubHeaderFragment", "Header Name " + headerName + " Selected");
        Log.w("SubHeaderFragment", "Category Size " +
                mCallBack.getMyCategories().get(headerName).length + "");
        Log.w("SubHeaderFragment", "SubHeader List First Cat Title: " +
                mCallBack.getMyCategories().get(headerName)[0].getTitle() + "");*/

        //get categories for corresponding header
        categories = mCallBack.getMyCategories()
                .get(headerName);

        // Populate list with our static array of categories.
        setListAdapter(new HeaderAdapter(getActivity(), categories));
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
            mCallBack = (OnSubHeaderSelectedListener) activity;

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
        //pass position selected and category
        mCallBack.onSubHeaderSelected(position, categories[position]);

        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);

    }

}