package com.example.harajtask

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedItem(
    val title: String,
    val username: String,
    val thumbnailURL: String,
    val city: String,
    val date: Long,
    val body: String,
    val commentCount: Int
) : Parcelable
