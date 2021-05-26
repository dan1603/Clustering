package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep
import com.dmitriy.moroz.clusteringapp.usecases.cluster.ClusterFlow
import com.dmitriy.moroz.clusteringapp.usecases.cluster.ClusterUseCases
import org.koin.dsl.module

@Keep
val useCasesModule = module {
    single<ClusterFlow> { ClusterUseCases(get()) }
}