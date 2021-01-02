package com.example.newsapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.model.database.ArticleDatabase
import com.example.newsapp.model.repository.NewsRepository
import com.example.newsapp.viewmodel.NewsViewModel
import com.example.newsapp.viewmodel.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private var toolbar: Toolbar? = null
//    private lateinit var pagerAdapter: ViewPagerAdapter
//    private lateinit var tab: TabLayout
//    private lateinit var viewPager: ViewPager

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.breakingNews, R.id.searchNews, R.id.savedNews))
        setupWithNavController(bottom_navigation, nav_fragment.findNavController())
        bottom_navigation.setupWithNavController(nav_fragment.findNavController())


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository = newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

//        setToolbar()
//        setTabs()
    }

//    private fun setTabs() {
//        pagerAdapter = ViewPagerAdapter(supportFragmentManager)
//        tab = findViewById(R.id.tab_layout)
//        viewPager = findViewById(R.id.viewpager)
//
//        viewPager.adapter = pagerAdapter
//        tab.setupWithViewPager(viewPager)
//
//        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
////                TODO("Not yet implemented")
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
////                TODO("Not yet implemented")
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
////                TODO("Not yet implemented")
//            }
//        })
//    }

//    private fun setToolbar() {
//        toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        toolbar?.title = "News"
//    }

}