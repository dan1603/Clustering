package com.dmitriy.moroz.clusteringapp.domain

import com.dmitriy.moroz.clusteringapp.base.BaseViewModel
import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.dmitriy.moroz.clusteringapp.usecases.cluster.ClusterFlow
import com.dmitriy.moroz.clusteringapp.utils.RxTransformers
import com.dmitriy.moroz.clusteringapp.utils.SingleLiveEvent
import com.google.android.gms.maps.model.LatLng
import io.reactivex.rxkotlin.subscribeBy

class ClusterViewModel(
    private val flow: ClusterFlow,
    private val rx: RxTransformers
) : BaseViewModel() {

    val pins = SingleLiveEvent<List<PinEntity>>()

    init {
        flow.getPins()
            .compose(rx.presentationFlowableTransformer())
            .subscribeBy(::onError) {
                pins.postValue(it)
            }
            .toDisposable()
    }

    fun fetchPins() = flow.fetchPins()
        .compose(rx.fetchingCompletableTransformer())
        .subscribe({ }, Throwable::printStackTrace)
        .toDisposable()

    fun selectPin(lat: Double, lng: Double) = flow.selectPin(lat, lng)
        .compose(rx.fetchingCompletableTransformer())
        .subscribe({ }, Throwable::printStackTrace)
        .toDisposable()
}