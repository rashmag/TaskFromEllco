package com.example.taskfromellco.data.remote_db

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        const val BASE_URL = "https://newsapi.org"
        const val API_KEY = "44a1614187004e8696022b5a1538c260"

        fun getClient():RestService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestService::class.java)
    }
}