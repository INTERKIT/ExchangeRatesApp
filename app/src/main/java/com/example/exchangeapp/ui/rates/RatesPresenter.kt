package com.example.exchangeapp.ui.rates

import com.example.exchangeapp.domain.RatesInteractor
import com.example.exchangeapp.ui.base.BasePresenter

class RatesPresenter(
    private val ratesInteractor: RatesInteractor
) : BasePresenter<RatesContract.View>(), RatesContract.Presenter {

}