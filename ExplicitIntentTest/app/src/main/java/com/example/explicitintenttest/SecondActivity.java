package com.example.explicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.textview);
        Intent i = getIntent();
        if(i.hasExtra("key")){
            String data = i.getStringExtra("key");
            tv.setText(data);
        }
    }
}