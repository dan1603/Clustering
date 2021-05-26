package com.dmitriy.moroz.clusteringapp.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dmitriy.moroz.clusteringapp.navigator.AppRouter
import com.dmitriy.moroz.clusteringapp.navigator.Navigator

abstract class BaseActivity<V: ViewBinding>: AppCompatActivity() {

    protected lateinit var binding: V

    protected lateinit var navigator: AppRouter

    abstract val inflater: (LayoutInflater) -> V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater.invoke(layoutInflater)
        navigator = Navigator(this)
        setContentView(binding.root)
        setupView(binding)
    }

    abstract fun setupView(binder: V)
}