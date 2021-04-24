package com.eternity.easyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;
import java.util.ArrayList;

public class BarcodeScanActivity extends AppCompatActivity {
    private int requestCodeCameraPermission = 1001;
    private CameraSource cameraSource;
    private BarcodeDetector barcodeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scan);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            askForCameraPermission();
        } else {
            setupControls();
        }
    }

    private void setupControls() {
        barcodeDetector = new BarcodeDetector.Builder(this).build();
        cameraSource = new CameraSource.Builder(this, barcodeDetector).setAutoFocusEnabled(true).build();

        SurfaceView cameraSurfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        cameraSurfaceView.getHolder().addCallback(new surfaceCallback());

        barcodeDetector.setProcessor(new processor());
    }

    private void askForCameraPermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.CAMERA},
                requestCodeCameraPermission);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == requestCodeCameraPermission && grantResults.length != 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupControls();
            } else {
                Toast.makeText(getApplicationContext(), "Отказано в доступе", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public class surfaceCallback implements SurfaceHolder.Callback {

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder holder) {

            if (ActivityCompat.checkSelfPermission(getParent().getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
               askForCameraPermission();
            } else {
                setupControls();
            }

            try {
                cameraSource.start(holder);
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Ой! Что-то пошло не так...", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) { }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
            cameraSource.stop();
        }
    }


    public class processor implements Detector.Processor<Barcode> {

        @Override
        public void release() {}

        @Override
        public void receiveDetections(@NonNull Detector.Detections<Barcode> detections) {
            if (detections.getDetectedItems().size() != 0) {
                SparseArray<Barcode> qrCodes = detections.getDetectedItems();
                Barcode code = qrCodes.valueAt(0);
                String value = code.displayValue;
            } else {
                String value = "";
            }
        }
    }
}