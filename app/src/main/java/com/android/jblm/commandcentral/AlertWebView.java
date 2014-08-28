package com.android.jblm.commandcentral;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Brian 2014.
 *
 * Creates a web view with mobile site to login for alerts
 * A button is placed i a fragment above the webview and takes user to main launcher
 */
public class AlertWebView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_web_view);
        WebView web = (WebView) findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://member.everbridge.net/index/453003085611338#/login");
    }

    //method for going home, nto sure if it recreates or just returns to activity
    //called by button press in activity
    public void openHome(View view)
    {
        Intent intent = new Intent(this, MainLauncher.class);
        startActivity(intent);
    }


}
