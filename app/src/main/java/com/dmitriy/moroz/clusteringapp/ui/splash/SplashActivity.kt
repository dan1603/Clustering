package com.dmitriy.moroz.clusteringapp.ui.splash

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.dmitriy.moroz.clusteringapp.base.BaseActivity
import com.dmitriy.moroz.clusteringapp.databinding.ActivitySplashBinding
import com.dmitriy.moroz.clusteringapp.utils.Constants

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val inflater: (LayoutInflater) -> ActivitySplashBinding
        get() = ActivitySplashBinding::inflate

    override fun setupView(binder: ActivitySplashBinding) {
        Handler(Looper.getMainLooper())
            .postDelayed({ navigator.openMapScreen() }, Constants.UI.SPLASH_DELAY)
    }

}