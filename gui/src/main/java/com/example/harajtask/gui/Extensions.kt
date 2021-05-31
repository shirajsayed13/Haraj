package com.example.harajtask.gui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.harajtask.WebServiceFailure
import com.google.android.material.imageview.ShapeableImageView
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


fun ShapeableImageView.loadImageFromUrl(
    imageUrl: String?,
    @DrawableRes placeholderResId: Int? = null
) {
    val builder = Glide.with(this).load(imageUrl)
    if (null != placeholderResId) builder.placeholder(placeholderResId)
    builder.listener(object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            this@loadImageFromUrl.scaleType = ImageView.ScaleType.CENTER_CROP
            return false
        }

    })
        .into(this)
}
