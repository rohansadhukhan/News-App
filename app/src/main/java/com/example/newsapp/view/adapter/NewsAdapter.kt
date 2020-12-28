package com.example.newsapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.database.entity.Article
import com.squareup.picasso.Picasso

class NewsAdapter(
    private var articles: ArrayList<Article>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    fun updateArticles(articles: ArrayList<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class NewsViewHolder(itemView: View, val listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val news_img: ImageView = itemView.findViewById(R.id.article_img)
        val news_title: TextView = itemView.findViewById(R.id.article_title)
        val news_description: TextView = itemView.findViewById(R.id.article_description)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            var position: Int = adapterPosition
            if (position == RecyclerView.NO_POSITION) {
                return
            } else {
                listener.onItemClick(position)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.article, parent, false), listener
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var article : Article = articles[position]
        holder.news_title.text = article.title
        holder.news_description.text = article.description
        Picasso.get()
            .load(article.urlToImage)
            .placeholder(R.drawable.news_demo)
            .into(holder.news_img)
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}