package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep
import com.dmitriy.moroz.clusteringapp.utils.RxTransformers
import org.koin.dsl.module

@Keep
val utilitiesModule = module {
    single<RxTransformers> { RxTransformers() }
}