package com.example.harajtask

import android.widget.Toast
import androidx.fragment.app.Fragment
import timber.log.Timber

internal fun Fragment.handleFailure(e: Exception?) {
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

internal fun Fragment.showErrorToast(msg: String) {
    AppToast.show(requireContext(), msg, Toast.LENGTH_SHORT)
}