package com.example.exchangeapp

import com.example.exchangeapp.data.model.RatesConverter
import com.example.exchangeapp.data.model.RatesResponse
import com.example.exchangeapp.data.network.RatesApi
import com.example.exchangeapp.domain.RatesRepository
import com.example.exchangeapp.domain.RatesRepositoryImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RatesRepositoryImplTest {

    private lateinit var ratesApi: RatesApi
    private lateinit var ratesRepository: RatesRepository

    @Before
    fun before() {
        ratesApi = mockk()
        ratesRepository =
            RatesRepositoryImpl(ratesApi)
    }

    @Test
    fun `fetch rates - remote success`() = runBlocking {
        val response = RatesResponse("GBP", hashMapOf("EUR" to 1.2))
        val expectedData = RatesConverter.fromApi(response)

        coEvery { ratesApi.fetchRates("GBP") } returns response

        val result = ratesRepository.fetchRates("GBP")

        assertEquals(result, expectedData)
    }

    @Test
    fun `fetch rates - remote error`() = runBlocking {
        val error = Exception()

        coEvery { ratesApi.fetchRates(any()) } throws error

        try {
            ratesRepository.fetchRates("GBP")
        } catch (e: Throwable) {
            assertEquals(error, e)
        }

        coVerify(exactly = 1) { ratesApi.fetchRates("GBP") }
    }
}