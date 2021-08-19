package com.example.mvvmcoroutineretrofitexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcoroutineretrofitexample.R
import com.example.mvvmcoroutineretrofitexample.databinding.PostListItemBinding
import com.example.mvvmcoroutineretrofitexample.model.Posts
import com.example.mvvmcoroutineretrofitexample.utils.RecyclerItemClickListener

class PostsAdapter(private val context:Context,private val lists: List<Posts>, private val itemClickListener: RecyclerItemClickListener.OnItemClickListener) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    private lateinit var binding: PostListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView(lists[position],itemClickListener)
    }

    inner class ViewHolder(private val binding: PostListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(post: Posts, itemClickListener: RecyclerItemClickListener.OnItemClickListener) {
            binding.titleTv.text = post.title
            binding.bodyTv.text = post.body
            binding.moreBtn.setOnClickListener {
                if (binding.moreBtn.text.toString() == context.getString(R.string.more)) {
                    binding.bodyTv.maxLines = Integer.MAX_VALUE
                    binding.moreBtn.text = context.getString(R.string.less)
                } else {
                    binding.bodyTv.maxLines = 2
                    binding.moreBtn.text = context.getString(R.string.more)
                }
            }
            binding.root.setOnClickListener {
                itemClickListener.onItemClick(binding.root, layoutPosition)
            }
        }
    }
}