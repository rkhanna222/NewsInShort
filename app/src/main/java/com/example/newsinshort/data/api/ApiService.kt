package com.example.newsinshort.data.api

import com.example.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://newsapi.org/v2/top-headlines?country=us&apiKey=56bcfef1b7444866a3dd2c1d0b1e16f1

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(

        @Query("country") country :String,
        @Query("apiKey") apiKey :String = "56bcfef1b7444866a3dd2c1d0b1e16f1",

    ): Response<NewsResponse>


}