package com.example.exchangeapp

import com.example.exchangeapp.data.model.Rate

object MockedData {

    val rates = listOf(
        Rate("EUR", "Euro", 1.2),
        Rate("US", "Dollar", 1.5)
    )

    val rates2 = listOf(
        Rate("CAD", "Dollar", 11.2),
        Rate("MXN", "Mexican", 133.5)
    )
}