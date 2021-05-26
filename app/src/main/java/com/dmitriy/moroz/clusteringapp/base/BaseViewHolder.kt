package com.dmitriy.moroz.clusteringapp.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T>(
    protected val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)

    open fun unbind() { }
}