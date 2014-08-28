package com.android.jblm.commandcentral.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.jblm.commandcentral.R;

import java.util.List;

/**
 * Created by Brian 2014.
 *
 * Creates a list view of phone numbers with buttons to dial the number
 */
public class PhoneAdapter extends ArrayAdapter<String> {

    private final Activity context;//parent view
    private final List<String> theList;//list of numbers

    /**
     * Constructor for phone number list view, accepts list of Strings for numbers
     * @param context Parent Activity
     * @param list list of numbers as Strings
     */
    public PhoneAdapter(FragmentActivity context, List<String> list) {
        super(context, R.layout.list_header_item, R.id.headerItem);
        this.context = context;
        theList = list;

    }

    //Get list size
    @Override
    public int getCount(){
        return theList.size();
    }

    /**
     * Serves view of phone number and button to list
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View theView;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            theView = inflater.inflate(R.layout.phone_number_list, null);

        } else {
            theView = convertView;
        }


        //iterrate through list of number strings, set the text view of numner
        //along with button to dial number
        for(String s: theList){
            final String num = s;
            TextView number = (TextView) theView.findViewById(R.id.phoneNumber);
            Button call = (Button) theView.findViewById(R.id.callButton);

            number.setText(num);
            call.setText("Call");
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String phone_no = num.replaceAll("-", "");//filter out the dashes
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);//dial, not CALL the number
                    callIntent.setData(Uri.parse("tel:" + phone_no));//prefix may not be needed
                    v.getContext().startActivity(callIntent);

                }
            });
        }


        return theView;
    }
}
