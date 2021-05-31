package com.example.harajtask.gui.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.harajtask.failure
import com.example.harajtask.fragment.BaseFragment
import com.example.harajtask.gui.R
import com.example.harajtask.gui.databinding.FragmentListingBinding
import com.example.harajtask.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListingFragment : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.fragment_listing

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ViewBinding
        get() = FragmentListingBinding::inflate

    override val binding: FragmentListingBinding
        get() = super.binding as FragmentListingBinding

    private val viewModel: ListingViewModel by viewModels()

    @Inject
    internal lateinit var listingAdapter: ListingAdapter

    override fun onInitView() {
        viewModel.apply {
            //failure(failure, ::handleFailure)
            observe(feedItems, { listingAdapter.feedItems = it })
            loadListing()
        }

        binding.apply {
            rvListing.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = listingAdapter
            }
        }

        listingAdapter.onFeedItemClickListener = {
            findNavController().navigate(
                ListingFragmentDirections.actionListingFragmentToDetailFragment(
                    it
                )
            )
        }
    }


}