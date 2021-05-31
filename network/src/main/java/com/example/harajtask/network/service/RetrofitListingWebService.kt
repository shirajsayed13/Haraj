package com.example.harajtask.network.service

import retrofit2.http.GET

internal interface RetrofitListingWebService {

    @GET("listing")
    suspend fun getListing(): ListingResponse
}