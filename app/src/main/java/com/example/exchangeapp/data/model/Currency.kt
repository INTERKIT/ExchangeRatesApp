package com.example.exchangeapp.data.model

import com.example.exchangeapp.R

data class Currency(
    val symbol: String,
    val name: String,
    val imageResourceId: Int
) {

    companion object {
        val EU = Currency(
            "EUR",
            "Euro",
            R.drawable.eu
        )
    }
}