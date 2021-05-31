package com.example.harajtask

import javax.inject.Inject

class GetListUseCase @Inject constructor(
    private val listingWebService: ListingWebService
) {

    suspend operator fun invoke(): List<FeedItem> {
        return listingWebService.getListItems()
    }
}