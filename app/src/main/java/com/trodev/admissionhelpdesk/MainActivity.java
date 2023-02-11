package com.trodev.admissionhelpdesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.BuildConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.trodev.admissionhelpdesk.university.AgriActivity;
import com.trodev.admissionhelpdesk.university.BuetActivity;
import com.trodev.admissionhelpdesk.university.GucchoActivity;
import com.trodev.admissionhelpdesk.university.NationalActivity;
import com.trodev.admissionhelpdesk.university.RckActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private CardView university, buet, rck, guccho, medical, agri, national, transport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Dashboard");

        FirebaseMessaging.getInstance().subscribeToTopic("notification");


        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        university = findViewById(R.id.university_btn);
        buet = findViewById(R.id.buet_btn);
        rck = findViewById(R.id.rck_btn);
        guccho = findViewById(R.id.guccho_btn);
        //  medical = findViewById(R.id.medical_btn);
        agri = findViewById(R.id.agri_btn);
        national = findViewById(R.id.national_btn);
        transport = findViewById(R.id.tranceport_btn);


        // eikhane eituku hocche amader navigation layout er kaj korar jonno.
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UniversityActivity.class));
            }
        });

        buet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BuetActivity.class));
            }
        });

        rck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RckActivity.class));
            }
        });

        guccho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GucchoActivity.class));
            }
        });

/*        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GucchoActivity.class));
            }
        });*/
        agri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AgriActivity.class));
            }
        });

        national.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NationalActivity.class));
            }
        });

        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shohoz.com/bus-tickets")));
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.nav_admisison_notice:
                Toast.makeText(this, "শীগ্রহী আসবে", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_req_dev:
                // startActivity(new Intent(MainActivity.this,RequestDeveloperActivity.class));
                Toast.makeText(this, "শীগ্রহী আসবে", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_dev:
                startActivity(new Intent(MainActivity.this, DeveloperActivity.class));
                Toast.makeText(this, "ডেভেলপার পরিচয়!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_policy:
                startActivity(new Intent(MainActivity.this, Policy.class));
                Toast.makeText(this, "প্রাইভেসি পলিসি!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Darus Sunnah Tahfijul Koran Madrasha");
                    String shareMessage = "\nAdmission Help Desk অ্যাপটি ডাউনলোড করুন\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                    Toast.makeText(this, "শেয়ার করুন!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    //e.toString();
                }

                break;
            case R.id.nav_rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                    Toast.makeText(this, "রেটিং দিন!", Toast.LENGTH_SHORT).show();
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}