package com.example.harajtask.network.service

import com.example.harajtask.model.FeedItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


internal fun ListingResponse.Data.Feed.toFeed() = FeedItem(
    title = title,
    username = username,
    thumbnailURL = thumbnailURL,
    city = city,
    date = date,
    body = body,
    commentCount = commentCount
)

@JsonClass(generateAdapter = true)
internal data class ListingResponse(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "data")
    val data: Data
) {
    @JsonClass(generateAdapter = true)
    internal data class Data(
        @Json(name = "feeds")
        val feeds: List<Feed>,
    ) {
        @JsonClass(generateAdapter = true)
        internal data class Feed(
            @Json(name = "title")
            val title: String,
            @Json(name = "username")
            val username: String,
            @Json(name = "thumbURL")
            val thumbnailURL: String,
            @Json(name = "city")
            val city: String,
            @Json(name = "date")
            val date: Long,
            @Json(name = "commentCount")
            val commentCount: Int,
            @Json(name = "body")
            val body: String
        )
    }
}