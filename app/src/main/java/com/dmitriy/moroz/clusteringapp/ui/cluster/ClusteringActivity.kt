package com.dmitriy.moroz.clusteringapp.ui.cluster

import android.annotation.SuppressLint
import android.view.LayoutInflater
import com.dmitriy.moroz.clusteringapp.R
import com.dmitriy.moroz.clusteringapp.base.BaseActivity
import com.dmitriy.moroz.clusteringapp.database.entity.PinEntity
import com.dmitriy.moroz.clusteringapp.databinding.ActivityClusteringBinding
import com.dmitriy.moroz.clusteringapp.domain.ClusterViewModel
import com.dmitriy.moroz.clusteringapp.utils.extensions.showIf
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.algo.GridBasedAlgorithm
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.floor

class ClusteringActivity : BaseActivity<ActivityClusteringBinding>(), OnMapReadyCallback {

    override val inflater: (LayoutInflater) -> ActivityClusteringBinding
        get() = ActivityClusteringBinding::inflate

    private val viewModel: ClusterViewModel by viewModel()

    private val markers = arrayListOf<MarkerOptions>()

    private var map: GoogleMap? = null

    private var clusterManager: ClusterManager<MarkerClusterItem>? = null

    override fun setupView(binder: ActivityClusteringBinding) {
        changeBottomSheetState(false)
        initMapUI()
        initBottomSheetUI()
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
        initClustering()
    }

    private fun initBottomSheetUI() = with(binding) {
        ivClose.setOnClickListener {
            changeBottomSheetState(false)
        }
    }

    private fun initMapUI() = with(
        supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    ) {
        getMapAsync(this@ClusteringActivity)
    }

    @SuppressLint("PotentialBehaviorOverride")
    private fun initClustering() {
        clusterManager = ClusterManager(this, map)
        clusterManager?.renderer = MarkerClusterRenderer(this, map, clusterManager)
        clusterManager?.algorithm = GridBasedAlgorithm()
        clusterManager?.setOnClusterClickListener { cluster ->
            map?.animateCamera(CameraUpdateFactory.newLatLngZoom(cluster.position, floor(map?.cameraPosition?.zoom!! + 1)))
            true
        }
        clusterManager?.setOnClusterItemClickListener { marker ->
            viewModel.selectPin(marker.position.latitude, marker.position.longitude)
            changeBottomSheetState(true)
            true
        }

        map?.setOnCameraIdleListener(clusterManager)
        map?.setOnMarkerClickListener(clusterManager)

        initViewModel()
    }

    private fun initViewModel() = viewModel.apply {
        pins.observe(this@ClusteringActivity, ::showCluster)
        fetchPins()
    }

    /**
     * For changing visibility state of views inside motion layout,
     * you need to use app:visibilityMode="ignore" for every view
     */
    private fun changeBottomSheetState(isVisible: Boolean) = with(binding) {
        homeCardExpandable.showIf(isVisible)
        ivArrow.showIf(isVisible)
        ivClose.showIf(isVisible)
    }

    private fun showCluster(cluster: List<PinEntity>) {
        markers.clear()
        markers.addAll(cluster.map { MarkerOptions().position(it.position).title(it.title) })

        markers.firstOrNull()?.let { marker ->
            map?.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.position, 13.0f))
        }

        clusterManager?.clearItems()
        markers.forEach { marker ->
            clusterManager?.addItem(MarkerClusterItem(marker.position, marker.title))
        }
        clusterManager?.cluster()
    }
}