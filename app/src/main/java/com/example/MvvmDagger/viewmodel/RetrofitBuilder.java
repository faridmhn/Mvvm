package com.example.MvvmDagger.viewmodel;

import com.example.MvvmDagger.service.repository.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder
{
    private final String baseUrl = "http://kqaz.ml/news_folder/";

    public Api retrofitConfig()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        return api;
    }
}
