package com.example.covid19india;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid19Service {

    @GET("dayone/country/IN")
    Call<String> getCovidData();
}
