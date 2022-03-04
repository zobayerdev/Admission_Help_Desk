package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class RuActivity extends AppCompatActivity {

    private WebView ru_webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("রাজশাহী বিশ্ববিদ্যালয়ে আবেদন");

        // Findin Button
        ru_webView = findViewById(R.id.ru_webView);

        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = ru_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        ru_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        ru_webView.setInitialScale(120);
        // Zoom korar jonno
        ru_webView.getSettings().setBuiltInZoomControls(true);
        ru_webView.setWebViewClient(new WebViewClient());

        ru_webView.loadUrl("https://application.ru.ac.bd/");

    }

    @Override
    public void onBackPressed() {
        if(ru_webView.canGoBack())
        {
            ru_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}