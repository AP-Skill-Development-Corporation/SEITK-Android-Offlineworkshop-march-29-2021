package com.example.pickersanddialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int c_year,c_month,c_day;
    int c_hour,c_minuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDatepicker(View view) {
        //DatePickerDialog
        Calendar c = Calendar.getInstance();
        c_year = c.get(Calendar.YEAR);
        c_month = c.get(Calendar.MONTH);
        c_day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String userselectedDate = dayOfMonth+"-"+month+"-"+year;
                        Toast.makeText(MainActivity.this,
                                userselectedDate, Toast.LENGTH_SHORT).show();



                    }
                },c_year,c_month,c_day);
        datePickerDialog.show();

    }

    public void openTimePicker(View view) {
        //TimePickerDialog
        Calendar c = Calendar.getInstance();
        c_hour = c.get(Calendar.HOUR_OF_DAY);
        c_minuite = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog =
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String userSelectedTime = hourOfDay+":"+minute;
                        Toast.makeText(MainActivity.this,
                                userSelectedTime, Toast.LENGTH_SHORT).show();

                    }
                },c_hour,c_minuite,false);
        timePickerDialog.show();

    }

    public void openAlerDialog(View view) {
        //AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure want to exit?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
            }
        });
        builder.show();
    }
}