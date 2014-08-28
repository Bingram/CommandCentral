package com.android.jblm.commandcentral.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.jblm.commandcentral.R;
import com.android.jblm.commandcentral.objects.Category;
import com.android.jblm.commandcentral.objects.Contact;
import com.android.jblm.commandcentral.objects.Header;

/**
 * Created by Brian 2014.
 *
 * Serves the views for each list fragment view using an array of objects.
 *
 * There is a constructor for each type of list view fragment
 */
public class HeaderAdapter extends ArrayAdapter<String> {

    private final Activity context;//parent activity
    private final Header[] theHeaderList;//array of headers
    private final Category[] theCategoryList;//array of categories
    private final Contact[] theContactList;//array of contacts

    /**
     * Constrcutor for Header list fragment adapter
     * @param context Parent Activity
     * @param list
     */
    public HeaderAdapter(FragmentActivity context, Header[] list) {
        super(context, R.layout.list_header_item, R.id.headerItem);
        this.context = context;
        theCategoryList = null;
        theContactList = null;
        theHeaderList = list;
    }

    /**
     * Constructor for Category list frgament adapter
     * @param context parent Activty
     * @param list array of Categories
     */
    public HeaderAdapter(FragmentActivity context, Category[] list) {
        super(context,  R.layout.list_header_item, R.id.headerItem);
        this.context = context;
        theHeaderList = null;
        theContactList = null;
        theCategoryList = list;
    }

    /**
     * Constructor for Contact list fragment adapter
     * @param context Parent Activity
     * @param list array of Contacts
     */
    public HeaderAdapter(FragmentActivity context, Contact[] list) {
        super(context, R.layout.list_header_item, R.id.headerItem);
        this.context = context;
        theHeaderList = null;
        theCategoryList = null;
        theContactList = list;
    }

    //counts the non-null list for this header adapter
    @Override
    public int getCount(){
        int size = 0;
        if(theHeaderList != null) {
            size = theHeaderList.length;
        } else if (theCategoryList != null){;
            size = theCategoryList.length;
        } else {
            size = theContactList.length;
        }

        return size;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View theView = null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            theView = inflater.inflate(R.layout.list_header_item, null);

        } else {
            theView = convertView;
        }


        //Text view being served by adapter
        TextView title = (TextView) theView.findViewById(R.id.headerItem);

        //Checks for null lists to decided which view to
        if(theHeaderList != null) {//show headers, set text of textview
            title.setText(theHeaderList[position].getName());
        } else if (theCategoryList != null){//show categories, set text of textview
            title.setText(theCategoryList[position].getTitle());
        } else {//show contacts, set text of textview
            title.setText(theContactList[position].contactName);
        }

        return theView;
    }

}
