package com.dmitriy.moroz.clusteringapp.network.communicator

import io.reactivex.Single

interface Communicator {
    fun getSampleData(): Single<List<String>>
}