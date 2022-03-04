package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class AgriActivity extends AppCompatActivity {
    private WebView agri_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agri);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("কৃষি-বিশ্ববিদ্যালয়ে আবেদন");

        // Findin Button
        agri_webView = findViewById(R.id.agri_webView);

        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = agri_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        agri_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        agri_webView.setInitialScale(120);
        // Zoom korar jonno
        agri_webView.getSettings().setBuiltInZoomControls(true);
        agri_webView.setWebViewClient(new WebViewClient());

        agri_webView.loadUrl("https://admission-agri.org/");
    }

    @Override
    public void onBackPressed() {
        if(agri_webView.canGoBack())
        {
            agri_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}