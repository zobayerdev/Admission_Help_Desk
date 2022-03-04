package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class RckActivity extends AppCompatActivity {

    private WebView rck_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rck);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("রুয়েট, চুয়েট, কুয়েট আবেদন");

        rck_webView = findViewById(R.id.rck_webView);


        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = rck_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        rck_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        rck_webView.setInitialScale(120);
        // Zoom korar jonno
        rck_webView.getSettings().setBuiltInZoomControls(true);
        rck_webView.setWebViewClient(new WebViewClient());

        rck_webView.loadUrl("https://admissionckruet.ac.bd/");

    }

    @Override
    public void onBackPressed() {
        if(rck_webView.canGoBack())
        {
            rck_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}