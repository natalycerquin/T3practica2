package com.example.practicat32;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface service {

    @GET("anime")
    Call<List<anime>> getAllAnimes();
}
