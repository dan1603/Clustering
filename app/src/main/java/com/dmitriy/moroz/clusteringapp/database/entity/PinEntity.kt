package com.dmitriy.moroz.clusteringapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dmitriy.moroz.clusteringapp.base.BaseEntity
import com.dmitriy.moroz.clusteringapp.utils.Constants
import com.google.android.gms.maps.model.LatLng

@Entity(tableName = Constants.Db.PIN)
data class PinEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val lat: Double,
    val lng: Double,
    val title: String,
    val isSelected: Boolean
) : BaseEntity() {

    val position: LatLng
        get() = LatLng(lat, lng)
}