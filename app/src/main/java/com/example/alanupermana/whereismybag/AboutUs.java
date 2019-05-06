package com.example.alanupermana.whereismybag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutUs extends AppCompatActivity {
    /* Variabel ImageView digunakan untuk intent, menunjukan ke halaman tertentu */
    ImageView ivBtnVarHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        /* Saat menu Home di klik, menuju class Home */
        ivBtnVarHome = findViewById(R.id.ivBtnHome);
        ivBtnVarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AboutUs.this,Home.class);
                startActivity(i);

            }
        });


    }
}