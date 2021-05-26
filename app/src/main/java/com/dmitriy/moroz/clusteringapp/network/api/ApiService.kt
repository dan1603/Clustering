package com.dmitriy.moroz.clusteringapp.network.api

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/todos")
    fun getSampleData(): Single<List<String>>

}