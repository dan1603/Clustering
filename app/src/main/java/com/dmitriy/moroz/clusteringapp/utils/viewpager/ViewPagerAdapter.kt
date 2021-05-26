package com.dmitriy.moroz.clusteringapp.utils.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import java.util.ArrayList

class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {

    private var itemList: MutableList<Fragment> = ArrayList()
    private var tittleList: MutableList<String> = ArrayList()

    override fun getCount(): Int = itemList.size

    override fun getItem(position: Int): Fragment = itemList[position]

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tittleList[position]
    }

    fun add(fragment: Fragment, title: String) {
        itemList.add(fragment)
        tittleList.add(title)
        notifyDataSetChanged()
    }
}