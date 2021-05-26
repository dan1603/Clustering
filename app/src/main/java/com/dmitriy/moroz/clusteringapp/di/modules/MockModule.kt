package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep
import com.dmitriy.moroz.clusteringapp.mock.MockClusterDataSource
import com.dmitriy.moroz.clusteringapp.mock.MockClusterDataSourceImpl
import org.koin.dsl.module

@Keep
val mockModule = module {
    single<MockClusterDataSource> { MockClusterDataSourceImpl() }
}