package com.dmitriy.moroz.clusteringapp.utils.viewpager

import androidx.viewpager.widget.ViewPager

abstract class ViewPagerListener: ViewPager.OnPageChangeListener {
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit

    override fun onPageSelected(position: Int) = Unit

    override fun onPageScrollStateChanged(state: Int) = Unit

    companion object {
        fun onPageSelected(callback: (Int) -> Unit) = object: ViewPagerListener() {
            override fun onPageSelected(position: Int) = callback(position)
        }
    }
}