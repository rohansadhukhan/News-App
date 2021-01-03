package com.example.newsapp.view.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.view.activity.MainActivity
import com.example.newsapp.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.article.*

class Article : Fragment(R.layout.article) {

    lateinit var viewModel: NewsViewModel
    val args: ArticleArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webView.apply {
            webChromeClient = WebChromeClient()
            loadUrl(article.url)
        }
        fab.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                viewModel.saveArticle(article)
                Snackbar.make(view, "Article Saved Successfully", Snackbar.LENGTH_SHORT).show()
            }
        })
    }

}