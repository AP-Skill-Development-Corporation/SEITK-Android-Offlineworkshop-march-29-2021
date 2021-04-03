package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button toast_b;
    int count = 0;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast_b = findViewById(R.id.toastButton);
        tv = findViewById(R.id.textview);
        toast_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast  makeText()
                //LENGTH_LONG    and LENGTH_SHORT
                Toast.makeText(MainActivity.this, "Welcome to SIETK",
                        Toast.LENGTH_LONG).show();
            }
        });


    }

    public void increamentCount(View view) {
        count++;
        tv.setText(String.valueOf(count));

    }
}