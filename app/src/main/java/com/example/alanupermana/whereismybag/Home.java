package com.example.alanupermana.whereismybag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class Home extends AppCompatActivity {
    /* Variabel ImageView digunakan untuk intent, menunjukan ke halaman tertentu */
    ImageView ivBtnVarScanme;
    ImageView ivBtnVarAboutus;
    ImageView ivBtnVarHelp;
    ImageView ivBtnVarFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* Saat menu Scanme di klik, menuju class ScanMe */
        ivBtnVarScanme = findViewById(R.id.ivBtnScanme);
        ivBtnVarScanme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,ScanMe.class);
                startActivity(i);
            }
        });

        /* Saat menu AboutUs di klik, menuju class AboutUs */
        ivBtnVarAboutus = findViewById(R.id.ivBtnAboutus);
        ivBtnVarAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,AboutUs.class);
                startActivity(i);
            }
        });

        /* Saat menu Help di klik, menuju class Help */
        ivBtnVarHelp = findViewById(R.id.ivBtnHelp);
        ivBtnVarHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,Help.class);
                startActivity(i);
            }
        });

        /* Saat menu Feedback di klik, menuju class Feedback */
        ivBtnVarFeedback = findViewById(R.id.ivBtnFeedback);
        ivBtnVarFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,Feedback.class);
                startActivity(i);

            }
        });

    }
}
