package com.example.exchangeapp.ui.rates.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.ViewGroup
import com.example.exchangeapp.R
import com.example.exchangeapp.data.model.CurrencyFactory
import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_rate.view.*

class RatesViewHolder(
    parent: ViewGroup,
    private val factory: CurrencyFactory,
    private val onItemClickListener: (Rate) -> Unit,
    private val onValueChanged: (String) -> Unit
) : BaseViewHolder<Rate>(parent, R.layout.item_rate) {

    private val currencyImageView = itemView.currencyImageView
    private val symbolTextView = itemView.symbolTextView
    private val nameTextView = itemView.nameTextView
    private val valueEditText = itemView.valueEditText

    private var listener: TextWatcher? = object : TextWatcher {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun afterTextChanged(text: Editable?) {
            onValueChanged(text.toString())
        }
    }

    override fun onBind(item: Rate, position: Int) {
        val data = factory.findCurrency(item.currency)

        currencyImageView.setImageResource(data.imageResourceId)
        symbolTextView.text = data.symbol
        nameTextView.text = data.name

        valueEditText.setText(item.value.toString())

        if (position == 0) {
            valueEditText.addTextChangedListener(listener)
            valueEditText.setSelection(valueEditText.text.length)
        }

        itemView.setOnClickListener {
            onItemClickListener.invoke(item)
            valueEditText.requestFocus()
        }
    }

    override fun onViewRecycled() {
        valueEditText.removeTextChangedListener(listener)
    }
}