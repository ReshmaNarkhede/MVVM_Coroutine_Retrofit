package com.example.mvvmcoroutineretrofitexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcoroutineretrofitexample.model.PostsRepository

class PostDetailViewModel:ViewModel() {
    private val postsRepository = PostsRepository()

    fun getSinglePost(id:Int?) = liveData {
        val receivedPosts = id?.let { postsRepository.getPostById(it) }
        emit(receivedPosts)
    }
}