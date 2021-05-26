package com.dmitriy.moroz.clusteringapp.di.modules

import androidx.annotation.Keep
import androidx.room.Room
import com.dmitriy.moroz.clusteringapp.database.AppDatabase
import com.dmitriy.moroz.clusteringapp.utils.Constants
import org.koin.dsl.module

@Keep
val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, Constants.Db.NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}