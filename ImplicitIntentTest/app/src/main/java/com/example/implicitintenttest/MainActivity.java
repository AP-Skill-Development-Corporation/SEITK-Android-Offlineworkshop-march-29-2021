package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void call(View view) {
        Uri u = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);

    }

    public void openUrl(View view) {
        Uri u = Uri.parse("https://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void myLocation(View view) {
        //Uri u = Uri.parse("geo:13.42838789999,79.5740338");
        Uri u = Uri.parse("geo:0,0?q=hospital");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}