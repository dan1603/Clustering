package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep
import com.dmitriy.moroz.clusteringapp.repository.clutster.ClusterRepository
import com.dmitriy.moroz.clusteringapp.repository.clutster.ClusterRepositoryProvider
import org.koin.dsl.module

@Keep
val repositoryModule = module {
    single<ClusterRepository> { ClusterRepositoryProvider(get(), get())}
}