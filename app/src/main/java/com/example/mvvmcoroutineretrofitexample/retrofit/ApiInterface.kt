package com.example.mvvmcoroutineretrofitexample.retrofit

import com.example.mvvmcoroutineretrofitexample.model.Posts
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): List<Posts>

    @GET("/posts/{id}")
    suspend fun getPostById(@Path(value = "id")postId:Int): Posts
}