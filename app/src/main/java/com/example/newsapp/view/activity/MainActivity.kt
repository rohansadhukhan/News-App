package com.example.newsapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.newsapp.R
import com.example.newsapp.view.adapter.ViewPagerAdapter
import com.example.newsapp.viewmodel.NewsViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private lateinit var pagerAdapter: ViewPagerAdapter
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        setToolbar()
        setTabs()
    }

    private fun setTabs() {
        pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        tab = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.viewpager)

        viewPager.adapter = pagerAdapter
        tab.setupWithViewPager(viewPager)

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
            }
        })
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = "News"
    }

}