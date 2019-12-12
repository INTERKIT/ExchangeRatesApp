package com.example.exchangeapp.data.model

object RatesConverter {

    fun fromApi(response: RatesResponse): List<Rate> {
        val rates = mutableListOf<Rate>()

        response.rates.forEach { (key, value) ->
            rates.add(Rate(key, value))
        }

        return rates
    }
}