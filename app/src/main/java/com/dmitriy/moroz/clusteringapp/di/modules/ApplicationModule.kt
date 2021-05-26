package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep

@Keep
val applicationModules = listOf(
    mockModule,
    networkModule,
    databaseModule,
    repositoryModule,
    useCasesModule,
    utilitiesModule,
    viewModelModule
)