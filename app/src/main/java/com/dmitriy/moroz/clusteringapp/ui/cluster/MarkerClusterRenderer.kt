package com.dmitriy.moroz.clusteringapp.ui.cluster

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterItem
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer

class MarkerClusterRenderer<T : ClusterItem>(
    context: Context,
    map: GoogleMap?,
    manager: ClusterManager<T>?
) : DefaultClusterRenderer<T>(context, map, manager) {

    override fun shouldRenderAsCluster(cluster: Cluster<T>): Boolean = cluster.size >= 2

    override fun onBeforeClusterItemRendered(item: T, markerOptions: MarkerOptions) {
        super.onBeforeClusterItemRendered(item, markerOptions)
        val markerDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
        markerOptions.icon(markerDescriptor).snippet(item.title)
    }

}