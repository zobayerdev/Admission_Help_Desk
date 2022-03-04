package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class JahangirActivity extends AppCompatActivity {

    private WebView jahangir_webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jahangir);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("জাহাঙ্গীরনগর বিশ্ববিদ্যালয়ে আবেদন");

        // Findin Button
        jahangir_webView = findViewById(R.id.jahangir_webView);

        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = jahangir_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        jahangir_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        jahangir_webView.setInitialScale(120);
        // Zoom korar jonno
        jahangir_webView.getSettings().setBuiltInZoomControls(true);
        jahangir_webView.setWebViewClient(new WebViewClient());

        jahangir_webView.loadUrl("https://juniv-admission.org/");

    }

    @Override
    public void onBackPressed() {
        if(jahangir_webView.canGoBack())
        {
            jahangir_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}