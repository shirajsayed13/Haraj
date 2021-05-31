package com.example.harajtask

import javax.inject.Inject

internal class AppListingWebService @Inject constructor(
    private val listingWebService: RetrofitListingWebService
) : ListingWebService {

    override suspend fun getListItems(): List<FeedItem> = networkCall(
        { listingWebService.getListing() },
        { response -> response.data.feeds.map { it.toFeed() } }
    )

}