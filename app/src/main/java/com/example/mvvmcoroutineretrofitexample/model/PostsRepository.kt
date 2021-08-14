package com.example.mvvmcoroutineretrofitexample.model

import com.example.mvvmcoroutineretrofitexample.retrofit.ApiInterface
import com.example.mvvmcoroutineretrofitexample.retrofit.RetrofitInstance
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class PostsRepository {
    var postService: ApiInterface = RetrofitInstance.apiService
    suspend fun getPosts(): List<Posts> = postService.getPosts()
    suspend fun getPostById(postId: Int):Posts = postService.getPostById(postId)
}