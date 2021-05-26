package com.dmitriy.moroz.clusteringapp.mock

import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import io.reactivex.Single
import java.util.*
import kotlin.random.Random

class MockClusterDataSourceImpl : MockClusterDataSource {

    override fun getClusterItems(): Single<List<PinEntity>> {
        val result = arrayListOf<PinEntity>()
        for (i in 0..100) {
            val (lat, lng) = getRandomCoordinates(i)
            result.add(
                PinEntity(
                    UUID.randomUUID().toString(),
                    lat,
                    lng,
                    "Pin#$i"
                )
            )
        }
        return Single.just(result)
    }

    private fun getRandomCoordinates(i: Int): Pair<Double, Double> =
        getRandomCoordinate(48.82, i) to getRandomCoordinate(34.74, i)


    private fun getRandomCoordinate(base: Double, i: Int): Double =
        if (Random.nextBoolean()) base + i
        else base - i

}