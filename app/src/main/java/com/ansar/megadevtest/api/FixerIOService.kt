package com.ansar.megadevtest.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val IN_QUALIFIER = "in:name,description"

interface FixerIOService {

    @GET("api/latest")
    suspend fun getRates(@Query("access_key") accessKey: String
    ): RatesResponse

    companion object {
        private const val BASE_URL = "http://data.fixer.io/"

        fun create(): FixerIOService {
            val logger = HttpLoggingInterceptor()
            logger.level = Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FixerIOService::class.java)
        }
    }
}
