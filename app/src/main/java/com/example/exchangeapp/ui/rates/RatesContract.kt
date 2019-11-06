package com.example.exchangeapp.ui.rates

import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.ui.base.MvpPresenter
import com.example.exchangeapp.ui.base.MvpView

interface RatesContract {

    interface View : MvpView {
        fun setRates(rates: List<Rate>)
    }

    interface Presenter : MvpPresenter<View> {

    }
}