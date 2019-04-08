package com.example.alanupermana.whereismybag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DialogBox extends AppCompatActivity {
    ImageView acceptance;
    ImageView cancellation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);

        acceptance = findViewById(R.id.accept);
        acceptance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DialogBox.this,Home.class);
                startActivity(i);

            }
        });

        cancellation = findViewById(R.id.cancel);
        cancellation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DialogBox.this,ShowLocation.class);
                startActivity(i);

            }
        });

    }
}
