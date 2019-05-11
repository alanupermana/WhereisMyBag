package com.example.alanupermana.whereismybag;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class ShowLocation extends AppCompatActivity {
    ImageView acceptance;
    TextView id,date,gate_in,aircraft,gate_out, location;

    FirebaseDatabase db;
    DatabaseReference dbRef;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_loaction);

        acceptance = findViewById(R.id.accept);
        acceptance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowLocation.this,DialogBox.class);
                startActivity(i);
            }
        });

        id = findViewById(R.id.tvIdisi);
        date = findViewById(R.id.tvDateIsi);
        gate_in = findViewById(R.id.tvGateinIsi);
        aircraft = findViewById(R.id.tvAircraftIsi);
        gate_out = findViewById(R.id.tvGateoutIsi);

        //AMBIL TEXT DARI CLASS SCANME
        Intent intent = getIntent();
        text = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        final ProgressDialog showD = ProgressDialog.show(
                ShowLocation.this,
                "Mengambil Data",
                "Mohon tunggu...",
                false,true);

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference().child("Ticket");

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(text)){
                    dbRef.child(text).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.e("ShowLoc", "onDataChange: " + dataSnapshot.toString());
                            ModelTicket data = dataSnapshot.getValue(ModelTicket.class);
                            showD.dismiss();
                            id.setText(dataSnapshot.getKey());
                            Date time = new Date((data.Date*1000));
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Log.e("ShowDate", "onDataChange: "+ sdf.toString() );
                            date.setText(sdf.format(time));
                            gate_in.setText(data.Gate_in);
                            aircraft.setText(data.Aircraft);
                            gate_out.setText(data.Gate_out);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else{
                    showD.dismiss();
                    ProgressDialog.show(
                            ShowLocation.this,
                            "Your id not valid",
                            "Please try again!",
                            false,true);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(ShowLocation.this,ScanMe.class);
                            startActivity(i);
                        }
                    }, 2000);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Log.e("ShowLocation", "onCreate: " + dbRef.toString() );
    }
}
