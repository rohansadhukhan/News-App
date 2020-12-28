package com.example.newsapp.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.newsapp.view.fragment.*

class ViewPagerAdapter(
    manager: FragmentManager
) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Home()
            }
            1 -> {
                National()
            }
            2 -> {
                International()
            }
            3 -> {
                Sports()
            }
            else -> {
                Crypto()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Home"
            }
            1 -> {
                "National"
            }
            2 -> {
                "International"
            }
            3 -> {
                "Sports"
            }
            else -> {
                "Crypto"
            }
        }
    }


}