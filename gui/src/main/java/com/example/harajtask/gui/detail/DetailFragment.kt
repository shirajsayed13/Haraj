package com.example.harajtask.gui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.viewbinding.ViewBinding
import com.example.harajtask.fragment.BaseFragment
import com.example.harajtask.gui.R
import com.example.harajtask.gui.convertLongToTime
import com.example.harajtask.gui.databinding.FragmentDetailBinding
import com.example.harajtask.gui.loadImageFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.fragment_detail

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ViewBinding
        get() = FragmentDetailBinding::inflate

    override val binding: FragmentDetailBinding
        get() = super.binding as FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()

    override fun onInitView() {
        val feedItem = args.feed
        binding.apply {
            if (feedItem != null) {
                ivProduct.loadImageFromUrl(feedItem.thumbnailURL)
                tvTitle.text = feedItem.title
                tvCity.text = feedItem.city
                tvDate.text = convertLongToTime(feedItem.date)
                tvSellerName.text = feedItem.username
                tvDescription.text = feedItem.body
            }
        }
    }


}