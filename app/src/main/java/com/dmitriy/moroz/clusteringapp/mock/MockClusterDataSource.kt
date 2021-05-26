package com.dmitriy.moroz.clusteringapp.mock

import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import io.reactivex.Single

interface MockClusterDataSource {

    fun getClusterItems(): Single<List<PinEntity>>
}