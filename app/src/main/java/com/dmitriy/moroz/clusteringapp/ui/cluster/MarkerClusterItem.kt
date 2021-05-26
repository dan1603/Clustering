package com.dmitriy.moroz.clusteringapp.ui.cluster

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class MarkerClusterItem(
    private val latLng: LatLng,
    private val label: String
) : ClusterItem {

    override fun getPosition(): LatLng = latLng

    override fun getTitle(): String = label

    override fun getSnippet(): String = label
}