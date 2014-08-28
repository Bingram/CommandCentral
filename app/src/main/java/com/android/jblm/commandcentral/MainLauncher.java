package com.android.jblm.commandcentral;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Brian 2014.
 *
 * Main Activity, called by the AndroidManifest.XML file on app launch.
 *
 * Controls the main screen on application start, displaying the icons and
 * linking them to their respective Activities.
 */
public class MainLauncher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);//sets Activity layout to correct layout XML

    }

    /**
     * Opens the about Dialog Fragment from the 'About' button
     * Details other than title are set in the layout file.
     * @param view may not be needed
     */
    public void openAbout(View view){

        // Created a new Dialog
        Dialog dialog = new Dialog(this);

        // Set the title
        dialog.setTitle("About This App");

        // inflate the layout
        dialog.setContentView(R.layout.about_layout);

        // Display the dialog
        dialog.show();

    }

    /**
     * Creates a phonebookactivty intent and starts it
     * @param view
     */
    public void openDirectory(View view)
    {
        Intent intent = new Intent(this, PhoneBookActivity.class);
        startActivity(intent);
    }

    /**
     * Creates a news activity intent and starts it
     * @param view
     */
    public void openNews(View view)
    {
        Intent intent = new Intent(this, News.class);
        startActivity(intent);
    }

    /**
     * Creates a map activity intent and starts it
     * @param view
     */
    public void openMap(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    /**
     * Creates a calendar activty intent and starts it
     * @param view
     */
    public void openCalendar(View view)
    {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }

    /**
     * Creates an alert signup activity intent and starts it
     * @param view
     */
    public void openAlertSignup(View view)
    {
        Intent intent = new Intent(this, AlertSignup.class);
        startActivity(intent);
    }

}
