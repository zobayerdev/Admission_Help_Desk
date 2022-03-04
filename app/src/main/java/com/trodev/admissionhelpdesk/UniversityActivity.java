package com.trodev.admissionhelpdesk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.trodev.admissionhelpdesk.university.CuActivity;
import com.trodev.admissionhelpdesk.university.DuActivity;
import com.trodev.admissionhelpdesk.university.JahangirActivity;
import com.trodev.admissionhelpdesk.university.RuActivity;

public class UniversityActivity extends AppCompatActivity {

    private CardView du_btn, ru_btn, cu_btn, jnu_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("বিশ্ববিদ্যালয় অ্যাডমিশন");

        du_btn = findViewById(R.id.du_btn);
        ru_btn = findViewById(R.id.ru_btn);
        cu_btn = findViewById(R.id.cu_btn);
        jnu_btn = findViewById(R.id.jnu_btn);


        du_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniversityActivity.this, DuActivity.class));
            }
        });

        ru_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniversityActivity.this, RuActivity.class));
            }
        });

        cu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniversityActivity.this, CuActivity.class));

            }
        });

        jnu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniversityActivity.this, JahangirActivity.class));
            }
        });
    }
}