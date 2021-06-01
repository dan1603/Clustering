package com.dmitriy.moroz.clusteringapp.ui.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dmitriy.moroz.clusteringapp.base.BaseFragment
import com.dmitriy.moroz.clusteringapp.databinding.FragmentPinDetailBinding
import com.dmitriy.moroz.clusteringapp.domain.PinDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PinDetailFragment : BaseFragment<FragmentPinDetailBinding>() {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPinDetailBinding
        get() = FragmentPinDetailBinding::inflate

    private val viewModel: PinDetailViewModel by viewModel()

    override fun getVM(): PinDetailViewModel = viewModel

    @SuppressLint("SetTextI18n")
    override fun setupView(binder: FragmentPinDetailBinding) = with(binder) {
        viewModel.pin.observe(viewLifecycleOwner) { pin ->
            tvData.text = pin.title
            tvLat.text = "Lat: ${pin.lat}"
            tvLng.text = "Lng: ${pin.lng}"
        }
    }
}