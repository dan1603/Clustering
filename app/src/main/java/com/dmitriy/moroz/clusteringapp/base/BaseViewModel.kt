package com.dmitriy.moroz.clusteringapp.base

import androidx.lifecycle.ViewModel
import com.dmitriy.moroz.clusteringapp.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {

    val error = SingleLiveEvent<String>()
    val loading = SingleLiveEvent<Boolean>()

    protected var initialLoadComplete = false

    private val disposables = CompositeDisposable()

    protected fun Disposable.toDisposable() = add(this)

    protected fun add(disposable: Disposable) {
        disposables.add(disposable)
    }

    protected fun addAll(vararg disposable: Disposable) {
        disposables.addAll(*disposable)
    }

    protected fun remove(disposable: Disposable) {
        disposables.remove(disposable)
    }

    protected fun clear() {
        disposables.clear()
    }

    protected fun onError(t: Throwable) {
        onLoadFinished()
        error.postValue(t.localizedMessage)
    }

    protected fun onLoadStarted() {
        loading.postValue(true)
    }

    protected fun onLoadFinished() {
        initialLoadComplete = true
        loading.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        clear()
    }
}