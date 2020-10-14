package it.alexs.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import it.alexs.news_library.model.Article
import it.alexs.newsapp.R
import it.alexs.newsapp.databinding.NewsItemBinding

class NewsAdapter: ListAdapter<Article, NewsAdapter.NewsViewHolder>(DIFF_CALLBACK) {
    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>(){
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class NewsViewHolder(val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindTo(article: Article){
            binding.newsAuthor.text = binding.newsAuthor.context.getString(R.string.news_author, article.author)
            binding.newsDescription.text = article.description
            binding.newsTitle.text = article.title
        }
    }
}