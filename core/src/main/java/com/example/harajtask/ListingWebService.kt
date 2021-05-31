package com.example.harajtask

interface ListingWebService {
    suspend fun getListItems(): List<FeedItem>
}