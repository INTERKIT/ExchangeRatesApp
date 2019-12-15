package com.example.exchangeapp.data.model

object RatesConverter {

    fun fromApi(response: RatesResponse): List<Rate> =
        response.rates.map { (key, value) ->
            Rate(response.base, key, value)
        }
}