package com.example.exchangeapp.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    view: View
) : RecyclerView.ViewHolder(view) {

    constructor(
        parent: ViewGroup,
        @LayoutRes layoutId: Int
    ) : this(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))

    open fun onBind(item: T, position: Int) {}

    open fun onViewRecycled() {}
}