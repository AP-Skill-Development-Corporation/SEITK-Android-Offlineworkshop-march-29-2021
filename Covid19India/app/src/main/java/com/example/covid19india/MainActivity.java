package com.example.covid19india;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    //https://api.covid19api.com/dayone/country/IN
    //BASE URL ==> https://api.covid19api.com
    //PAth  ==>  dayone/country/IN
    //Query parameter ==>


    //https://www.googleapis.com/books/v1/volumes?q=harrypotter

    RecyclerView rv;
    Retrofit retrofit;
    List<CovidData> list;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd = new ProgressDialog(this);
        pd.setMessage("Please wait....");
        pd.setCancelable(false);
        pd.show();
        list = new ArrayList<>();
        rv = findViewById(R.id.recyclerview);
        retrofit = new Retrofit.Builder().baseUrl("https://api.covid19api.com")
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        Covid19Service service = retrofit.create(Covid19Service.class);
        Call<String> call = service.getCovidData();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Log.i("APSSDC",response.body());
                Toast.makeText(MainActivity.this, response.body(),
                        Toast.LENGTH_SHORT).show();
                try {
                    JSONArray jsonArray = new JSONArray(response.body());
                    for (int i = 0;i<jsonArray.length();i++){
                        JSONObject indexObject = jsonArray.getJSONObject(i);
                        String date = indexObject.getString("Date");
                        String activecases = indexObject.getString("Active");
                        String recovered = indexObject.getString("Recovered");
                        String detahs = indexObject.getString("Deaths");
                        String confirmedcases = indexObject.getString("Confirmed");
                        Log.i("APSSDC",date+"\n"+"activecases: "+activecases+"\n"
                        +"RecoveredCases: "+recovered+"\n"+"Deaths: "+detahs+"\n"
                        +"ConfirmedCases: "+confirmedcases);
                        CovidData data = new CovidData(date,activecases,recovered,detahs,confirmedcases);
                        list.add(data);

                    }
                    Collections.reverse(list);
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    CovidAdapter adapter = new CovidAdapter(MainActivity.this,list);
                    rv.setAdapter(adapter);
                    pd.dismiss();




                    Log.i("SIZE",""+list.size());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });





    }
}