package com.trodev.admissionhelpdesk.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.trodev.admissionhelpdesk.R;

public class DuActivity extends AppCompatActivity {

    private WebView du_webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ঢাকা বিশ্ববিদ্যালয়ে আবেদন");

        // Findin Button
        du_webView = findViewById(R.id.du_webView);

        //website er sokol setting korar jonno kora hoyeche.
        WebSettings webSettings = du_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        du_webView.getSettings().setLoadWithOverviewMode(true);

        //এইখানে আমাদের ওয়েবসাইট গুলো সাইজ দেওয়া হয়েছে।
        du_webView.setInitialScale(120);
        // Zoom korar jonno
        du_webView.getSettings().setBuiltInZoomControls(true);
        du_webView.setWebViewClient(new WebViewClient());

        du_webView.loadUrl("https://adma394c127769905e430433c93686fab3a.eis.du.ac.bd/en/b45de047fde9788cadae3cfe8e88dcc2");

    }

    @Override
    public void onBackPressed() {
        if(du_webView.canGoBack())
        {
            du_webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}