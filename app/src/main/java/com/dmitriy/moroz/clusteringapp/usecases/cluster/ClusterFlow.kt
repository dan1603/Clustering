package com.dmitriy.moroz.clusteringapp.usecases.cluster

import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable

interface ClusterFlow {

    fun fetchPins() : Completable

    fun getPins() : Flowable<List<PinEntity>>

    fun getSelectedPin() : Flowable<PinEntity>

    fun selectPin(lat: Double, lng: Double) : Completable
}