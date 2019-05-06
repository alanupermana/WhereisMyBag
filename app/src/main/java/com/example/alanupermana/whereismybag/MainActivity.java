package com.example.alanupermana.whereismybag;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler();
        long delay = 2000L;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Home.class));
                finish();
            }
        },3000); //3000 L = 3 detik


    }




}
