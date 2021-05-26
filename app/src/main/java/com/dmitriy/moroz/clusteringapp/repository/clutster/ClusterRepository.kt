package com.dmitriy.moroz.clusteringapp.repository.clutster

import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface ClusterRepository {
    fun fetchPins() : Completable

    fun getPins() : Flowable<List<PinEntity>>
}