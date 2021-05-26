package com.dmitriy.moroz.clusteringapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dmitriy.moroz.clusteringapp.utils.extensions.showToast

abstract class BaseFragment<V: ViewBinding>: Fragment() {

    protected lateinit var binding: V
    abstract val inflater: (LayoutInflater, ViewGroup?, Boolean) -> V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = this.inflater.invoke(inflater, container, false)
        setupView(binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupView(binding)
    }

    override fun onDestroy() {
        getVM()?.apply {
            error.removeObservers(viewLifecycleOwner)
            loading.removeObservers(viewLifecycleOwner)
        }
        super.onDestroy()
    }

    abstract fun getVM(): BaseViewModel?

    abstract fun setupView(binder: V)

    open fun onError(error: String) {
        requireContext().showToast(error)
    }

    open fun onLoadingChanged(isLoading: Boolean) {}

    private fun setupViewModel() = getVM()?.apply {
        error.observe(viewLifecycleOwner, ::onError)
        loading.observe(viewLifecycleOwner, ::onLoadingChanged)
    }
}