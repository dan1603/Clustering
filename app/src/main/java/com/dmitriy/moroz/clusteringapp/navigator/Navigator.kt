package com.dmitriy.moroz.clusteringapp.navigator

import android.content.Intent
import com.dmitriy.moroz.clusteringapp.base.BaseActivity
import com.dmitriy.moroz.clusteringapp.ui.cluster.ClusteringActivity

class Navigator(override var source: BaseActivity<*>) : AppRouter {

    override fun openMapScreen() {
        source.startActivity(Intent(source, ClusteringActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }

}