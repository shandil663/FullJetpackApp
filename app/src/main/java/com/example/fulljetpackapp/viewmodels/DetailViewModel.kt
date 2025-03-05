package com.example.fulljetpackapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fulljetpackapp.models.TweetList
import com.example.fulljetpackapp.repository.TweetRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class DetailViewModel @Inject constructor(private val repository: TweetRepository) : ViewModel() {


    val tweet: StateFlow<List<TweetList>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            repository.getTweets("android")
        }

    }
}