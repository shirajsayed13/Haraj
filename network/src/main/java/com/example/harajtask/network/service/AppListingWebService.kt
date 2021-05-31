package com.example.harajtask.network.service

import com.example.harajtask.*
import com.example.harajtask.networkCall
import javax.inject.Inject

internal class AppListingWebService @Inject constructor(
    private val listingWebService: RetrofitListingWebService
) : ListingWebService {

    override suspend fun getListItems(): List<FeedItem> = networkCall(
        { listingWebService.getListing() },
        { response -> response.data.feeds.map { it.toFeed() } }
    )

}