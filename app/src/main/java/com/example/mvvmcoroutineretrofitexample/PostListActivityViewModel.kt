package com.example.mvvmcoroutineretrofitexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcoroutineretrofitexample.model.PostsRepository

class PostListActivityViewModel : ViewModel() {
    private val postsRepository = PostsRepository()
    val posts = liveData {
        val receivedPosts = postsRepository.getPosts()
        emit(receivedPosts)
    }
}