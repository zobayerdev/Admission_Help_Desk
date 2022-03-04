package com.trodev.admissionhelpdesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.UUID;

public class RequestDeveloperActivity extends AppCompatActivity {

    private EditText phone_ET, text_ET;
    private Button submit_feedback;
    private DatabaseReference reference;

    private String request_phone,request_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_developer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Give Suggestion");


        phone_ET = findViewById(R.id.mobile_ET);
        text_ET = findViewById(R.id.text_ET);
        submit_feedback = findViewById(R.id.submit_feedback);

        reference = FirebaseDatabase.getInstance().getReference("Request User");

        submit_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });

    }

    private void checkValidation() {
        String req_number = phone_ET.getText().toString().trim();
        String req_text = text_ET.getText().toString().trim();

        if(req_number.isEmpty())
        {
            phone_ET.setError("Mobile number is required!");
            phone_ET.requestFocus();
            return;
        }
        else if(req_text.isEmpty())
        {
            text_ET.setError("Your suggestion is required!");
            text_ET.requestFocus();
            return;
        }
        else
        {
            completeRequest(req_number,req_text);
        }

    }

    private void completeRequest(String req_phone,String req_text) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile",req_phone);
        hashMap.put("sms",req_text);


        String uniqueId = UUID.randomUUID().toString();

        reference.child(uniqueId).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {

                Toast.makeText(RequestDeveloperActivity.this, "Feedback submit successful!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(RequestDeveloperActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}