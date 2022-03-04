package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class CuActivity extends AppCompatActivity {
private WebView cu_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("চট্টগ্রাম বিশ্ববিদ্যালয়ে আবেদন");

        // Findin Button
        cu_webView = findViewById(R.id.cu_webView);

        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = cu_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        cu_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        cu_webView.setInitialScale(120);
        // Zoom korar jonno
        cu_webView.getSettings().setBuiltInZoomControls(true);
        cu_webView.setWebViewClient(new WebViewClient());

        cu_webView.loadUrl("https://admission.cu.ac.bd/application-process\n");

    }

    @Override
    public void onBackPressed() {
        if(cu_webView.canGoBack())
        {
            cu_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}