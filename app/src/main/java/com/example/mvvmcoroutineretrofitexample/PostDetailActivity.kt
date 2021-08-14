package com.example.mvvmcoroutineretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcoroutineretrofitexample.databinding.ActivityPostDetailBinding
import com.example.mvvmcoroutineretrofitexample.model.Posts

class PostDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: PostDetailViewModel
    private lateinit var binding: ActivityPostDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PostDetailViewModel::class.java)

        val postId = intent.getIntExtra("INDEX",0)
        getPostDetail(postId)
    }

    private fun getPostDetail(postId: Int?) {
        viewModel.getSinglePost(postId).observe(this, {
            it?.let { it1 -> setupUI(it1) }
        })
    }

    private fun setupUI(post: Posts) {
        binding.progressBar.visibility = View.GONE
        binding.postTitle.text = post.title
        binding.postBody.text = post.body
    }
}