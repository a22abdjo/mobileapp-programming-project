package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.appcompat.app.AppCompatActivity;


@SuppressWarnings("FieldCanBeLocal")
public class SkorActivity extends AppCompatActivity {


    private WebView myWebView;

    public void showExternalWebPage() {
        Intent intent = new Intent(SkorActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void showInternalWebPage() {
        myWebView.loadUrl("file:///android_asset/about.html");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skor_activity);

        myWebView = findViewById(R.id.my_webview);
        myWebView.setWebViewClient(new WebViewClient()); // Do not open in Chrome!
        WebSettings websettings = myWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("file:///android_asset/about.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //noinspection SimplifiableIfStatement
        int id = item.getItemId();
        if (id == R.id.action_external_web) {
            Log.d("==>", "Will display external web page");
            showExternalWebPage();
            return true;
        }

        if (id == R.id.action_internal_web) {
            Log.d("==>", "Will display internal web page");
            showInternalWebPage();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}


