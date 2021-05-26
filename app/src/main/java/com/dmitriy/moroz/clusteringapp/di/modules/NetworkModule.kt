package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep
import com.dmitriy.moroz.clusteringapp.di.builders.NetworkBuilder
import org.koin.dsl.module

@Keep
val networkModule = module {
    single { NetworkBuilder() }
    single { get<NetworkBuilder>().initOkHttpClient() }
    single { get<NetworkBuilder>().initRetrofitBuilder(get()) }
    single { get<NetworkBuilder>().initRetrofitApiInterface(get()) }
    single { get<NetworkBuilder>().initServerCommunicator(get()) }
}