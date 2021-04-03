package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textview);
        tv.append("onCreate() \n");
        Log.i("APSSDC","onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv.append("onStart() \n");
        Log.i("APSSDC","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.append("onResume() \n");
        Log.i("APSSDC","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv.append("onPause() \n");
        Log.i("APSSDC","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv.append("onStop() \n");
        Log.i("APSSDC","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv.append("onDestroy() \n");
        Log.i("APSSDC","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv.append("onRestart() \n");
        Log.i("APSSDC","onRestart()");
    }
}