package com.example.alanupermana.whereismybag;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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
    //private ListView listView;
    //private String JSON_STRING;
    TextView id,date,gate_in,aircraft,gate_out, location;

    FirebaseDatabase db;
    DatabaseReference dbRef;

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

        //listView = findViewById(R.id.listView);
        //getJSON();


        id = findViewById(R.id.tvIdisi);
        date = findViewById(R.id.tvDateIsi);
        gate_in = findViewById(R.id.tvGateinIsi);
        aircraft = findViewById(R.id.tvAircraftIsi);
        gate_out = findViewById(R.id.tvGateoutIsi);

        //TEST
        location = findViewById(R.id.tvLocation);
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        location.setText(text);

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference().child("Ticket").child("wimb000001");
        Log.e("ShowLocation", "onCreate: "+ dbRef.toString() );

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("ShowLoc", "onDataChange: " + dataSnapshot.toString());
                ModelTicket data = dataSnapshot.getValue(ModelTicket.class);
                id.setText(dataSnapshot.getKey());
                Date time = new Date(data.Date*1000);
                SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
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










    }
//    private void showEmployee(){
//
//        JSONObject jsonObject;
//        ArrayList<HashMap<String,String>> list = new ArrayList<>();
//        try {
//            jsonObject = new JSONObject(JSON_STRING);
//            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
//
//            for (int i = 0; i < result.length();i++){
//
//                JSONObject object = result.getJSONObject(i);
//                String id = object.getString(Konfigurasi.TAG_ID);
//                String name = object.getString(Konfigurasi.TAG_NAMA);
//
//                HashMap<String,String> employees = new HashMap<>();
//                employees.put(Konfigurasi.TAG_ID,id);
//                employees.put(Konfigurasi.TAG_NAMA,name);
//                list.add(employees);
//            }
//        } catch (JSONException e) {
//            new AlertDialog.Builder(ShowLocation.this)
//                    .setMessage(e.getMessage())
//                    .show();
//        }catch (NullPointerException e){
//            new AlertDialog.Builder(ShowLocation.this)
//                    .setMessage(e.getMessage())
//                    .show();
//        }
//
//        ListAdapter adapter = new SimpleAdapter(
//                ShowLocation.this,list,R.layout.list_item,
//                new String[] {Konfigurasi.TAG_ID,Konfigurasi.TAG_NAMA},
//                new int[] {R.id.id,R.id.name});
//        listView.setAdapter(adapter);
//    }
//
//    private void getJSON(){
//
//        class GetJSON extends AsyncTask<Void,Void,String>{
//            ProgressDialog loading;
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                loading = ProgressDialog.show(
//                        ShowLocation.this,
//                        "Mengambil Data",
//                        "Mohon tunggu...",
//                        false,true);
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                super.onPostExecute(s);
//                loading.dismiss();
//                JSON_STRING = s;
//                showEmployee();
//            }
//
//            @Override
//            protected String doInBackground(Void... voids) {
//                RequestHandler rh = new RequestHandler();
//                String s =rh.sendGetRequest(Konfigurasi.URL_GET_ALL,ShowLocation.this);
//                return s;
//            }
//        }
//
//        GetJSON js = new GetJSON();
//        js.execute();
//    }




}
