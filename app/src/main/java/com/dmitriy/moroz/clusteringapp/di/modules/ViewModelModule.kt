package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep
import com.dmitriy.moroz.clusteringapp.domain.ClusterViewModel
import com.dmitriy.moroz.clusteringapp.domain.PinDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@Keep
val viewModelModule = module(override = true) {
    viewModel { ClusterViewModel(get(), get()) }
    viewModel { PinDetailViewModel(get(), get()) }
}