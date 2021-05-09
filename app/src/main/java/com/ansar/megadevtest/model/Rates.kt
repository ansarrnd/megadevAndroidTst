package com.ansar.megadevtest.model

import java.io.Serializable

data class Rates(
    val imgSrc: Int,
    val currency: String,
    val currencyRate: Double
): Serializable
