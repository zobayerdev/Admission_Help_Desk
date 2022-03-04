package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class BuetActivity extends AppCompatActivity {

    private WebView buet_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("বুয়েট অ্যাডমিশন");

        buet_webView = findViewById(R.id.buet_webView);


        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = buet_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        buet_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        buet_webView.setInitialScale(120);
        // Zoom korar jonno
        buet_webView.getSettings().setBuiltInZoomControls(true);
        buet_webView.setWebViewClient(new WebViewClient());

        buet_webView.loadUrl("http://ugadmission.buet.ac.bd/");

    }

    @Override
    public void onBackPressed() {
        if (buet_webView.canGoBack()) {
            buet_webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
}