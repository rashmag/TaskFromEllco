package com.example.taskfromellco.data.remote_db

class DataManager {
    private val restService: RestService? = null
    suspend fun getEverything(query:String, page:Int, apiKey:String) =restService?.getEverything(query, page, apiKey)
    suspend fun getHeadlines(countryCode:String, page:Int, apiKey:String) =restService?.getHeadlines(countryCode, page, apiKey)
}