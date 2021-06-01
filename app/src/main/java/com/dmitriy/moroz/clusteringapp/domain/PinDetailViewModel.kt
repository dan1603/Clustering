package com.dmitriy.moroz.clusteringapp.domain

import androidx.lifecycle.MutableLiveData
import com.dmitriy.moroz.clusteringapp.base.BaseViewModel
import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.dmitriy.moroz.clusteringapp.usecases.cluster.ClusterFlow
import com.dmitriy.moroz.clusteringapp.utils.RxTransformers
import io.reactivex.rxkotlin.subscribeBy

class PinDetailViewModel(
    flow: ClusterFlow,
    rx: RxTransformers
) : BaseViewModel() {

    val pin = MutableLiveData<PinEntity>()

    init {
        flow.getSelectedPin()
            .compose(rx.presentationFlowableTransformer())
            .subscribeBy(Throwable::printStackTrace) {
                pin.postValue(it)
            }
            .toDisposable()
    }
}