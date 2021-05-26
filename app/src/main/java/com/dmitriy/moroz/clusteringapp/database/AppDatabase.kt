package com.dmitriy.moroz.clusteringapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dmitriy.moroz.clusteringapp.database.dao.PinDao
import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.dmitriy.moroz.clusteringapp.utils.Constants

@Database(
    entities = [
        PinEntity::class
    ],
    version = Constants.Db.VERSION,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pinDao(): PinDao
}