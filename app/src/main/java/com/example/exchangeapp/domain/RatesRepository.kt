package com.example.exchangeapp.domain

import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.data.model.RatesConverter
import com.example.exchangeapp.data.network.RatesApi

interface RatesRepository {
    suspend fun fetchRates(base: String): List<Rate>
}

class RatesRepositoryImpl(
    private val ratesApi: RatesApi
) : RatesRepository {

    override suspend fun fetchRates(base: String): List<Rate> {
        val response = ratesApi.fetchRates(base)
        return RatesConverter.fromApi(response)
    }
}