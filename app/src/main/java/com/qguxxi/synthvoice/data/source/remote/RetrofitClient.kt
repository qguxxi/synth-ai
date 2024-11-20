package com.qguxxi.synthvoice.data.source.remote

import com.qguxxi.synthvoice.api.OpenAIApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.openai.com/"

    val apiService: OpenAIApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenAIApiService::class.java)
    }
}