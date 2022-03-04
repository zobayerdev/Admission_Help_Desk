package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class NationalActivity extends AppCompatActivity {

    private WebView national_webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ন্যাশনাল বিশ্ববিদ্যালয়ে আবেদন");

        // Findin Button
        national_webView = findViewById(R.id.national_webView);

        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = national_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        national_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        national_webView.setInitialScale(100);
        // Zoom korar jonno
        national_webView.getSettings().setBuiltInZoomControls(true);
        national_webView.setWebViewClient(new WebViewClient());

        national_webView.loadUrl("http://app1.nu.edu.bd/");

    }

    @Override
    public void onBackPressed() {
        if(national_webView.canGoBack())
        {
            national_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}