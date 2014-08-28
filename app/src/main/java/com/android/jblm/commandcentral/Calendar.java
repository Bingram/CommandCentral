package com.android.jblm.commandcentral;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Currently a cheat as the google calendr doesn't allow consolodation fo XML/RSS feeds
 * Using a html iframe provided by google embedded in html file, the web calendar
 * can be viewed using a web view in the activity.
 */
public class Calendar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        WebView mWebView = null;
        mWebView = (WebView) findViewById(R.id.calWebview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/gcal.html");
    }

}
