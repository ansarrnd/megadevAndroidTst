package com.ansar.megadevtest.api

import com.google.gson.JsonObject

/**
 * Data class to hold repo responses from searchRepo API calls.
 */
data class RatesResponse(
    val success: Boolean,
    val timestamp: Long,
    val base: String,
    val date: String,
    val rates: JsonObject
)
