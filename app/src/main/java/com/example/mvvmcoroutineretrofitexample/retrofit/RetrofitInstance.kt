package com.example.mvvmcoroutineretrofitexample.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val apiService: ApiInterface by lazy {
            Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(ApiInterface::class.java)
    }
}