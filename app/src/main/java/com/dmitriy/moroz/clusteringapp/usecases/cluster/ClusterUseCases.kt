package com.dmitriy.moroz.clusteringapp.usecases.cluster

import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.dmitriy.moroz.clusteringapp.repository.clutster.ClusterRepository
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable

class ClusterUseCases(
    private val repository: ClusterRepository
) : ClusterFlow {

    override fun fetchPins(): Completable = repository
        .fetchPins()

    override fun getPins(): Flowable<List<PinEntity>> = repository
        .getPins()

    override fun getSelectedPin(): Flowable<PinEntity> = repository
        .getSelectedPin()

    override fun selectPin(lat: Double, lng: Double): Completable = repository
        .selectPin(lat, lng)

}