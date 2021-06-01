package com.example.harajtask.webservice

import com.example.harajtask.model.FeedItem

interface ListingWebService {
    suspend fun getListItems(): List<FeedItem>
}