package com.example.exchangeapp.domain

import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.utils.NumberUtils

class RatesInteractor(
    private val ratesRepository: RatesRepository
) {

    suspend fun fetchRates(base: String, amount: Double): List<Rate> =
        ratesRepository.fetchRates(base).map {
            val value = NumberUtils.round(it.value * amount, 2)
            it.copy(value = value)
        }
}