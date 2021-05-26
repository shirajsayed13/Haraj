package com.example.harajtask.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.harajtask.fragment.BaseFragment
import com.example.harajtask.gui.R
import com.example.harajtask.gui.databinding.FragmentListingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListingFragment : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.fragment_listing

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ViewBinding
        get() = FragmentListingBinding::inflate

    override fun onInitView() {
        TODO("Not yet implemented")
    }

}