package com.example.exchangeapp.di

import com.example.exchangeapp.data.network.RatesApi
import com.example.exchangeapp.domain.RatesInteractor
import com.example.exchangeapp.domain.RatesRepository
import com.example.exchangeapp.domain.RatesRepositoryImpl
import com.example.exchangeapp.ui.rates.RatesContract
import com.example.exchangeapp.ui.rates.RatesPresenter
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object RatesModule : InjectionModule {

    override fun create() = module {
        factory { get<Retrofit>().create(RatesApi::class.java) }

        factory { RatesPresenter(get()) } bind RatesContract.Presenter::class

        factory { RatesInteractor(get()) }
        single { RatesRepositoryImpl(get()) } bind RatesRepository::class
    }
}