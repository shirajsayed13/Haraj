package com.example.harajtask.gui.listing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.FeedItem
import com.example.harajtask.gui.databinding.ItemListingBinding
import com.example.harajtask.gui.loadImageFromUrl
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import kotlin.properties.Delegates

@FragmentScoped
internal class ListingAdapter @Inject constructor() :
    RecyclerView.Adapter<ListingAdapter.ListingViewHolder>() {

    internal var onFeedItemClickListener: (FeedItem) -> Unit = { }

    internal var feedItems: List<FeedItem> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun getItemCount(): Int = feedItems.size

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) =
        holder.bind(feedItems[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder =
        ListingViewHolder(
            ItemListingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    inner class ListingViewHolder(private val binding: ItemListingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onFeedItemClickListener(
                    feedItems[adapterPosition]
                )
            }
        }

        fun bind(feedItem: FeedItem) {
            binding.apply {
                tvTitle.text = feedItem.title
                tvSellerName.text = feedItem.username
                tvPlace.text = feedItem.city
                ivProduct.loadImageFromUrl(feedItem.thumbnailURL)
                if (feedItem.commentCount > 0) {
                    tvChat.visibility = View.VISIBLE
                    tvChat.text = "(${feedItem.commentCount})"
                } else {
                    tvChat.visibility = View.INVISIBLE
                }

            }
        }
    }
}