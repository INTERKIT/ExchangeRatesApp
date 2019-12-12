package com.example.exchangeapp.ui.rates.adapter

import android.view.ViewGroup
import com.example.exchangeapp.data.model.CurrencyFactory
import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.ui.base.BaseAdapter
import com.example.exchangeapp.ui.base.BaseViewHolder

class RatesAdapter(
    private val factory: CurrencyFactory,
    private val onItemClickListener: (Rate) -> Unit,
    private val onValueChangedListener: (String) -> Unit
) : BaseAdapter<Rate>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Rate> =
        RatesViewHolder(
            parent,
            factory,
            onItemClickListener,
            onValueChangedListener
        )

    override fun onViewRecycled(holder: BaseViewHolder<Rate>) {
        super.onViewRecycled(holder)
        holder.onViewRecycled()
    }
}