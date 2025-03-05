package com.example.fulljetpackapp.api

import com.example.fulljetpackapp.models.Tweet
import com.example.fulljetpackapp.models.TweetList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface tweetAPI {
    @GET("v3/b/67c5d818acd3cb34a8f44af7?meta=false")
    suspend fun getTweet(@Header("X-JSON-Path") category: String): Response<List<TweetList>>

    @GET("/v3/b/67c5d818acd3cb34a8f44af7?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCat(): Response<List<String>>
}