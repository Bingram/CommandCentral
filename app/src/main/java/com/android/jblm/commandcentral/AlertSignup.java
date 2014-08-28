package com.android.jblm.commandcentral;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Brian 2014.
 */
public class AlertSignup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_signup);
    }


    //Open alert webview activity
    public void openWebView(View view){
        Intent intent = new Intent(this, AlertWebView.class);
        startActivity(intent);
    }


}
