package com.example.exchangeapp.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected val data = mutableListOf<T>()

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) =
        holder.onBind(data[position], position)

    open fun setItems(items: List<T>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}