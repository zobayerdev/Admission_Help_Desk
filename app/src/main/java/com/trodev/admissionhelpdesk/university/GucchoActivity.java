package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class GucchoActivity extends AppCompatActivity {

    private WebView guccho_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guccho);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("গুচ্ছ অ্যাডমিশন আবেদন");


        // Findin Button
        guccho_webView = findViewById(R.id.guccho_webView);

        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = guccho_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        guccho_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        guccho_webView.setInitialScale(120);
        // Zoom korar jonno
        guccho_webView.getSettings().setBuiltInZoomControls(true);
        guccho_webView.setWebViewClient(new WebViewClient());

        guccho_webView.loadUrl("https://gstadmission.ac.bd/");

    }

    @Override
    public void onBackPressed() {
        if(guccho_webView.canGoBack())
        {
            guccho_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}