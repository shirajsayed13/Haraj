package com.example.harajtask.gui.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.harajtask.GetListingUseCase
import com.example.harajtask.FeedItem
import com.example.harajtask.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        viewModelScope.launch(Dispatchers.Default) {
            try {
                _feedItems.postValue(getListingUseCase())
            } catch (e: Exception) {
                _failure.postValue(e)
            }
        }
    }
}