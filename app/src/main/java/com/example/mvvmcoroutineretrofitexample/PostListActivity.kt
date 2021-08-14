package com.example.mvvmcoroutineretrofitexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcoroutineretrofitexample.adapter.PostsAdapter
import com.example.mvvmcoroutineretrofitexample.databinding.ActivityPostListBinding
import com.example.mvvmcoroutineretrofitexample.model.Posts

class PostListActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPostListBinding
    private lateinit var viewModel : PostListActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PostListActivityViewModel::class.java)

        getPosts()
    }

    private fun getPosts(){
        viewModel.posts.observe(this, {
            setupUI(it)
        })
    }

    private fun setupUI(lists: List<Posts>) {
        binding.progressBar.visibility = View.GONE
        binding.postList.visibility = View.VISIBLE
        binding.postList.layoutManager = LinearLayoutManager(this)
        val adapter = PostsAdapter(this,lists){_,position ->
            val post = lists[position]
            val intent = Intent(this, PostDetailActivity::class.java)
            intent.putExtra("INDEX", post.id)
            startActivity(intent)
        }
        binding.postList.adapter = adapter
    }
}