package com.example.harajtask.usecase

import com.example.harajtask.model.FeedItem
import com.example.harajtask.webservice.ListingWebService
import javax.inject.Inject

class GetListingUseCase @Inject constructor(
    private val listingWebService: ListingWebService
) {

    suspend operator fun invoke(): List<FeedItem> {
        return listingWebService.getListItems()
    }
}