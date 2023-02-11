package com.trodev.admissionhelpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Policy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("প্রাইভেসি পলিসি");
    }
}