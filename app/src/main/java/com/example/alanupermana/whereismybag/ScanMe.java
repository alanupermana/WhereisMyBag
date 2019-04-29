package com.example.alanupermana.whereismybag;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import android.content.Context;
import android.os.Vibrator;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;

import java.io.IOException;

import static com.example.alanupermana.whereismybag.MainActivity.EXTRA_TEXT;

public class ScanMe extends AppCompatActivity {

    SurfaceView cameraPreview;
    CameraSource cameraSource;
    TextView textIdScanme;
    BarcodeDetector barcodeDetector;
    ImageView scanme;

    String textID = "wimb000001";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanme);

        cameraPreview = findViewById(R.id.cameraPreview);
        textIdScanme = findViewById(R.id.textIdScanme);



        scanme = findViewById(R.id.scanmeToscan);
        scanme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowLocation();
            }
        });

        //BARCODE DETECTOR
        barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE).build();

        //SIZE CAMERA
        cameraSource = new CameraSource.Builder(this, barcodeDetector).setRequestedPreviewSize(750, 750).build();

        //AKSES CAMERA
        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //PERMISSION CAMERA
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                try{
                    cameraSource.start(holder);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) { cameraSource.stop(); }
        });

        // SET DETECTOR
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() { }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();
                if(qrCodes.size()!=0){
                    textIdScanme.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(10);
                            textIdScanme.setText(qrCodes.valueAt(0).displayValue); }
                    });
                    //SharedPreferences mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
                }
            }
        });
    }
    public void openShowLocation() {
        String text = textIdScanme.getText().toString();
        Intent intent = new Intent(this, ShowLocation.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);

    }
}

