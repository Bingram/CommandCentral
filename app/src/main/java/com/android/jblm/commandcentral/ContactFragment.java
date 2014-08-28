package com.android.jblm.commandcentral;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.jblm.commandcentral.objects.Contact;

/**
 * Created by Brian on 8/21/2014.
 */
public class ContactFragment extends android.support.v4.app.Fragment {

    private Contact myContact;
    private getContactListener mCallBack;

    public interface getContactListener{
        Contact getCurContact();
        public void showPhoneList();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        myContact = mCallBack.getCurContact();

        final View theView = inflater.inflate(R.layout.contact_view, container, false);

        TextView name = (TextView) theView.findViewById(R.id.contactName);
        TextView desc = (TextView) theView.findViewById(R.id.contactDesc);

        name.setText(myContact.contactName);
        desc.setText(myContact.contactDesc);

        Button phones = (Button) theView.findViewById(R.id.phoneButton);
        Button web = (Button) theView.findViewById(R.id.webButton);
        Button email = (Button) theView.findViewById(R.id.emailButton);

        phones.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.showPhoneList();
            }
        });

        web.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = myContact.contactURL;

                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;

                Uri link = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, link);
                v.getContext().startActivity(launchBrowser);
            }
        });

        email.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",myContact.contactEmail, null));
                v.getContext().startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            }
        });

        return theView;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallBack = (getContactListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeaderSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

}
