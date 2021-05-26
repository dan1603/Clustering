package com.dmitriy.moroz.clusteringapp.network.communicator

import com.dmitriy.moroz.clusteringapp.network.api.ApiService
import io.reactivex.Single

class ServerCommunicator(
    private val api: ApiService
): Communicator {

    override fun getSampleData(): Single<List<String>> = api.getSampleData()

}