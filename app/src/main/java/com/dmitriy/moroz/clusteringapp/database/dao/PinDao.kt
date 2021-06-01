package com.dmitriy.moroz.clusteringapp.database.dao

import androidx.room.*
import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.dmitriy.moroz.clusteringapp.utils.Constants
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface PinDao {

    @Query("SELECT * FROM ${Constants.Db.PIN} ORDER BY isSelected DESC")
    fun queryFlow(): Flowable<List<PinEntity>>

    @Query("SELECT * FROM ${Constants.Db.PIN} WHERE isSelected = 1 LIMIT 1")
    fun querySelected(): Flowable<PinEntity>

    @Query("SELECT * FROM ${Constants.Db.PIN}")
    fun queryAll(): Single<List<PinEntity>>

    @Query("SELECT * FROM ${Constants.Db.PIN} WHERE id = :key")
    fun queryById(key: Int): Single<PinEntity>

    @Query("SELECT id FROM ${Constants.Db.PIN} WHERE lat = :latitude AND lng = :longitude LIMIT 1")
    fun queryIdByCoordinates(latitude: Double, longitude: Double): Single<String>

    @Query("UPDATE ${Constants.Db.PIN} SET isSelected = CASE id WHEN :pinId THEN 1 ELSE 0 END")
    fun selectById(pinId: String) : Completable

    @Query("UPDATE ${Constants.Db.PIN} SET isSelected = 0")
    fun deselectAll(): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<PinEntity>) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: PinEntity) : Completable

    @Delete
    fun deleteList(list: List<PinEntity>) : Completable

    @Delete
    fun deleteItem(item: PinEntity) : Completable

    @Query("DELETE FROM ${Constants.Db.PIN}")
    fun deleteAll() : Completable
}