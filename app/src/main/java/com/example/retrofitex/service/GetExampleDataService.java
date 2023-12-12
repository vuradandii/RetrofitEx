package com.example.retrofitex.service;

import com.example.retrofitex.model.ExampleModel;
import com.example.retrofitex.model.Rating;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetExampleDataService {
    @GET("products")
    Call<ExampleModel> getRating();
}
