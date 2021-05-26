package com.dmitriy.moroz.clusteringapp.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH: BaseViewHolder<T>, T>: RecyclerView.Adapter<VH>() {

    protected var data: ArrayList<T> = ArrayList()

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: VH) {
        holder.unbind()
        super.onViewRecycled(holder)
    }

    fun getItem(position: Int) = data[position]

    fun getItemPosition(item: T): Int {
        return data.indexOf(item)
    }

    fun addAll(list: List<T>) {
        with(data) { addAll(list) }
        notifyDataSetChanged()
    }

    fun add(item: T) {
        with(data) { add(item) }
        notifyDataSetChanged()
    }

    fun clear() {
        with(data) { clear() }
        notifyDataSetChanged()
    }

    open fun updateList(list: List<T>) {
        with(data) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }
}