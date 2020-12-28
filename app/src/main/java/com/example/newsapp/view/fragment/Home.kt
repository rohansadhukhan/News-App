package com.example.newsapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.database.entity.Article
import com.example.newsapp.view.activity.MainActivity
import com.example.newsapp.view.adapter.NewsAdapter
import com.example.newsapp.viewmodel.NewsViewModel

class Home : Fragment(), NewsAdapter.OnItemClickListener {

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: NewsAdapter
    private var articles : ArrayList<Article> = ArrayList()

    private lateinit var viewModel : NewsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_default, container,false)


        setRecyclerView(view)

        viewModel = (activity as MainActivity).viewModel
        viewModel.getTopNews("in")
        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            articles = it as ArrayList<Article>
            adapter.updateArticles(articles)
        })


        return view
    }

    override fun onItemClick(position: Int) {
//        TODO("Not yet implemented")
    }

    private fun setRecyclerView(view : View) {
        adapter = NewsAdapter(articles, this)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

}