package com.example.harajtask.gui.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.model.FeedItem
import com.example.harajtask.usecase.GetListingUseCase
import com.example.harajtask.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class ListingViewModel @Inject constructor(
    private val getListingUseCase: GetListingUseCase
) : BaseViewModel() {

    private val _feedItems: MutableLiveData<List<FeedItem>> by lazy { MutableLiveData() }
    internal val feedItems: LiveData<List<FeedItem>> = _feedItems

    internal fun loadListing() {
        Timber.d("loadListing: ")
        launchUseCase {
            _feedItems.postValue(getListingUseCase())
        }
    }
}