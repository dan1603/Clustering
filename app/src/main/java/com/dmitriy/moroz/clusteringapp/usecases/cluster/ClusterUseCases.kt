package com.dmitriy.moroz.clusteringapp.usecases.cluster

import com.dmitriy.moroz.clusteringapp.repository.clutster.ClusterRepository
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable

class ClusterUseCases(
    private val repository: ClusterRepository
) : ClusterFlow {

    override fun fetchPins(): Completable = repository.fetchPins()

    override fun getPins(): Flowable<List<Pair<String, LatLng>>> = repository
        .getPins()
        .map { pins ->
            pins.map { it.title to LatLng(it.lat, it.lng) }
        }

}