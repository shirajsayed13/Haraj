package com.example.harajtask.listing

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.FeedItem
import com.example.harajtask.gui.databinding.ItemListingBinding
import com.example.harajtask.layoutInflater
import javax.inject.Inject
import kotlin.properties.Delegates

internal class ListingAdapter @Inject constructor() :
    RecyclerView.Adapter<ListingAdapter.ListingViewHolder>() {

    internal var onUsedItemClickListener: (FeedItem, position: Int) -> Unit = { _, _ -> }

    internal var feedItems: List<FeedItem> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun getItemCount(): Int = feedItems.size

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) =
        holder.bind(feedItems[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder =
        ListingViewHolder(ItemListingBinding.inflate(parent.layoutInflater, parent, false))

    inner class ListingViewHolder(private val binding: ItemListingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onUsedItemClickListener(
                    feedItems[adapterPosition],
                    adapterPosition
                )
            }
        }

        fun bind(feedItem: FeedItem) {
            binding.apply {
                binding.tvTitle.text = feedItem.title
            }
        }
    }
}