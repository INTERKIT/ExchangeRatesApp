package com.example.exchangeapp.data.model

import android.content.Context
import com.example.exchangeapp.R

class CurrencyFactory(
    private val context: Context
) {
    private val currencyArray = context.resources.getStringArray(R.array.country_array)

    fun findCurrency(symbol: String): Currency {
        val currency = currencyArray.find { it.startsWith(symbol) } ?: return Currency.EU

        val data = currency.split(',')

        val currencySymbol = data.first().trim()
        val name = data[1].trim()
        val resourceId = getResourceByName(data.last().trim())

        return Currency(currencySymbol, name, resourceId)
    }

    private fun getResourceByName(name: String): Int =
        context.resources.getIdentifier(name, "drawable", context.packageName)
}