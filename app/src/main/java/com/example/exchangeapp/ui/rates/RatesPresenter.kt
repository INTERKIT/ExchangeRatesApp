package com.example.exchangeapp.ui.rates

import com.example.exchangeapp.R
import com.example.exchangeapp.data.model.Currency
import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.domain.RatesInteractor
import com.example.exchangeapp.ui.base.BasePresenter
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.properties.Delegates

private const val DELAY_IN_MILLIS = 1000L

class RatesPresenter(
    private val ratesInteractor: RatesInteractor
) : BasePresenter<RatesContract.View>(), RatesContract.Presenter {

    private var currentSymbol: String by Delegates.observable(Currency.EU.symbol) { _, oldValue, newValue ->
        isNewCurrency = newValue != oldValue
        if (isNewCurrency) fetchRates(newValue, currentAmount)
    }

    private var currentAmount: Double by Delegates.observable(1.0) { _, oldValue, newValue ->
        if (newValue != oldValue) fetchRates(currentSymbol, newValue)
    }

    private var ratesJob: Job? = null

    private var isNewCurrency = false

    override fun setAmount(amount: String) {
        currentAmount = amount.toDoubleOrNull() ?: 0.0
    }

    override fun setCurrency(currency: String) {
        currentSymbol = currency
    }

    override fun start() {
        fetchRates(currentSymbol, currentAmount)
    }

    override fun refresh() {
        try {
            fetchRates(currentSymbol, currentAmount)
        } finally {
            view?.setRefreshing(false)
        }
    }

    private fun fetchRates(base: String, amount: Double) {
        ratesJob?.cancel()
        ratesJob = launch {
            try {
                while (true) {
                    val rates = ratesInteractor.fetchRates(base, amount)
                    val first = listOf(Rate(base, base, amount))

                    onRatesReceived(first + rates)
                    delay(DELAY_IN_MILLIS)
                }
            } catch (e: CancellationException) {
                Timber.d("Rates fetching cancelled")
            } catch (e: Throwable) {
                Timber.e(e, "Failed to fetch rates")
                view?.showError(R.string.error_occurred)
            }
        }
    }

    private fun onRatesReceived(rates: List<Rate>) {
        if (isNewCurrency) {
            view?.updateRates(rates)
            isNewCurrency = false
        } else {
            view?.insertRates(rates)
        }
    }
}