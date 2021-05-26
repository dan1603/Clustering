package com.dmitriy.moroz.clusteringapp.utils

import io.reactivex.CompletableTransformer
import io.reactivex.FlowableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxTransformers {

    fun <T> presentationFlowableTransformer(): FlowableTransformer<T, T> = FlowableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> presentationSingleTransformer(): SingleTransformer<T, T> = SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> fetchingSingleTransformer(): SingleTransformer<T, T> = SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
    }

    fun fetchingCompletableTransformer(): CompletableTransformer = CompletableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
    }

}