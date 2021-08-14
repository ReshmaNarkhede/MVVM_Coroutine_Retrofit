package com.example.mvvmcoroutineretrofitexample.model

import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("userId")
    val userId: Int
)
