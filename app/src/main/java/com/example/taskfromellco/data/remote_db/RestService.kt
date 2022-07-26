package com.example.taskfromellco.data.remote_db

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RestService {
    @GET("/v2/top-headlines")
    fun getAllNews(
        @Query("country") countryCode: String = "ru",
//        @Query("q") query:String,
        @Query("apiKey")apiKey:String = ApiClient.API_KEY
    ):Call<NewsResponce>

    @GET("/v2/top-headlines")
    fun getSearchNews(
        @Query("country") countryCode: String = "ru",
        @Query("q") query:String,
        @Query("apiKey")apiKey:String = ApiClient.API_KEY
    ):Call<NewsResponce>
}