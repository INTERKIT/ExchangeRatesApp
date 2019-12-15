package com.example.exchangeapp

import com.example.exchangeapp.domain.RatesInteractor
import com.example.exchangeapp.ui.rates.RatesContract
import com.example.exchangeapp.ui.rates.RatesPresenter
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RatesPresenterTest {

    @get:Rule
    val rule = CoroutinesTestWatcher()

    private lateinit var presenter: RatesPresenter
    private lateinit var ratesInteractor: RatesInteractor

    private lateinit var view: RatesContract.View

    @Before
    fun before() {
        ratesInteractor = mockk()
        view = mockk(relaxed = true)
        presenter = RatesPresenter(ratesInteractor)
        presenter.attach(view)
    }

    @Test
    fun `fetching rates - success`() = runBlocking {
        val base = "GBP"
        val amount = 1.0

        val rates = MockedData.rates

        coEvery { ratesInteractor.fetchRates(base, amount) } returns rates

        presenter.setCurrency(base)
        presenter.setAmount(amount.toString())
        presenter.start()

        val result = ratesInteractor.fetchRates(base, amount)
        assertEquals(result, rates)
    }

    @After
    fun after() {
        presenter.detach()
    }
}