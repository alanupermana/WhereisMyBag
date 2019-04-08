package com.example.alanupermana.whereismybag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class Home extends AppCompatActivity {
    ImageView buttonScanMe;
    ImageView buttonAboutUs;
    ImageView buttonHelp;
    ImageView buttonFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        buttonScanMe = findViewById(R.id.buttonscanme);
        buttonScanMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,ScanMe.class);
                startActivity(i);

            }
        });
        buttonAboutUs = findViewById(R.id.buttonaboutus);
        buttonAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,AboutUs.class);
                startActivity(i);

            }
        });
        buttonHelp = findViewById(R.id.buttonhelp);
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,Help.class);
                startActivity(i);

            }
        });
        buttonFeedback = findViewById(R.id.buttonfeedback);
        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,Feedback.class);
                startActivity(i);

            }
        });

    }
}
