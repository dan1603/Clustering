package com.dmitriy.moroz.clusteringapp.usecases.cluster

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable

interface ClusterFlow {

    fun fetchPins() : Completable

    fun getPins() : Flowable<List<Pair<String, LatLng>>>
}