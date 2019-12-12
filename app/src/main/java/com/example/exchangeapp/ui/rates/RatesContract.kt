package com.example.exchangeapp.ui.rates

import androidx.annotation.StringRes
import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.ui.base.MvpPresenter
import com.example.exchangeapp.ui.base.MvpView

interface RatesContract {

    interface View : MvpView {
        fun showRates(rates: List<Rate>)
        fun showError(@StringRes resourceId: Int)
        fun setRefreshing(isRefreshing: Boolean)
    }

    interface Presenter : MvpPresenter<View> {
        fun setCurrency(currency: String)
        fun setAmount(amount: String)
        fun start()
        fun refresh()
    }
}