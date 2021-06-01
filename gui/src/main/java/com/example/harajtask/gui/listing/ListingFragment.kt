package com.example.harajtask.gui.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.harajtask.webservice.WebServiceFailure
import com.example.harajtask.base.failure
import com.example.harajtask.base.fragment.BaseFragment
import com.example.harajtask.gui.R
import com.example.harajtask.gui.databinding.FragmentListingBinding
import com.example.harajtask.base.observe
import com.example.harajtask.gui.AppToast
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
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
            failure(failure, ::handleFailure)
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


    private fun handleFailure(e: Exception?) {
        Timber.v("handleFailure: IN")
        Timber.e(e)
        when (e) {
            is WebServiceFailure.NoNetworkFailure -> showErrorToast("No internet connection!")
            is WebServiceFailure.NetworkTimeOutFailure, is WebServiceFailure.NetworkDataFailure -> showErrorToast(
                "Internal server error!"
            )
            else -> showErrorToast("Unknown error occurred!")
        }
        Timber.v("handleFailure: OUT")
    }

    private fun Fragment.showErrorToast(msg: String) {
        AppToast.show(requireContext(), msg, Toast.LENGTH_SHORT)
    }

}