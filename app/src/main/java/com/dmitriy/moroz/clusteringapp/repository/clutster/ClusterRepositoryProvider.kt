package com.dmitriy.moroz.clusteringapp.repository.clutster

import com.dmitriy.moroz.clusteringapp.database.AppDatabase
import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.dmitriy.moroz.clusteringapp.mock.MockClusterDataSource
import io.reactivex.Completable
import io.reactivex.Flowable

class ClusterRepositoryProvider(
    private val dataSource: MockClusterDataSource,
    private val db: AppDatabase
) : ClusterRepository {

    override fun fetchPins(): Completable = db.pinDao().deleteAll()
        .andThen(dataSource.getClusterItems())
        .flatMapCompletable(db.pinDao()::insertList)

    override fun getPins(): Flowable<List<PinEntity>> = db
        .pinDao()
        .queryFlow()

}