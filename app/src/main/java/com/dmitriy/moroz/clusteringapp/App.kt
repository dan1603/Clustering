package com.dmitriy.moroz.clusteringapp

import android.app.Application
import com.dmitriy.moroz.clusteringapp.di.modules.applicationModules
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    private fun initDependencies() = startKoin {
        androidLogger()
        androidContext(this@App)
        modules(applicationModules)
    }

}