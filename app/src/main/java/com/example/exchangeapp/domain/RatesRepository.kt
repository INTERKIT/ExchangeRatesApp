package com.example.exchangeapp.domain

import com.example.exchangeapp.data.network.RatesApi

interface RatesRepository

class RatesRepositoryImpl(
    private val ratesApi: RatesApi
) : RatesRepository {

}