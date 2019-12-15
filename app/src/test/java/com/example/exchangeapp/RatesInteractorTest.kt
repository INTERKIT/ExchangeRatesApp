package com.example.exchangeapp

import com.example.exchangeapp.domain.RatesInteractor
import com.example.exchangeapp.domain.RatesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RatesInteractorTest {

    private lateinit var ratesRepository: RatesRepository
    private lateinit var ratesInteractor: RatesInteractor

    @Before
    fun before() {
        ratesRepository = mockk()
        ratesInteractor =
            RatesInteractor(ratesRepository)
    }

    @Test
    fun `fetching rates - remote success`() = runBlocking {
        val rates = MockedData.rates

        coEvery { ratesRepository.fetchRates("GBP") } returns rates

        val result = ratesInteractor.fetchRates("GBP", 1.0)

        assertEquals(rates, result)
    }

    @Test
    fun `fetching rates - remote error`() = runBlocking {
        val error = Exception()
        coEvery { ratesRepository.fetchRates(any()) } throws error

        try {
            ratesInteractor.fetchRates("GBP", 1.0)
        } catch (e: Throwable) {
            assertEquals(error, e)
        }

        coVerify(exactly = 1) { ratesRepository.fetchRates("GBP") }
    }
}