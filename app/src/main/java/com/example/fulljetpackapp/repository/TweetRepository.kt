package com.example.fulljetpackapp.repository

import com.example.fulljetpackapp.api.tweetAPI
import com.example.fulljetpackapp.models.TweetList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetAPI: tweetAPI) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetList>>(emptyList())
    val tweets: StateFlow<List<TweetList>>
        get() = _tweets

    suspend fun getCategory() {
        val response = tweetAPI.getCat()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweetAPI.getTweet(category)
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}