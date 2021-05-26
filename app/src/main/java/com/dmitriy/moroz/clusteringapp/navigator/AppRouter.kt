package com.dmitriy.moroz.clusteringapp.navigator

import com.dmitriy.moroz.clusteringapp.base.BaseActivity

interface AppRouter {
    var source: BaseActivity<*>
    fun openMapScreen()
}