package com.example.harajtask.gui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.harajtask.gui.R
import com.example.harajtask.gui.activity.BaseActivity
import com.example.harajtask.gui.databinding.ActivityHarajBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class HarajActivity : BaseActivity() {

    override val layoutResId: Int
        get() = R.layout.activity_haraj

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = ActivityHarajBinding::inflate

    override val binding: ActivityHarajBinding
        get() = super.binding as ActivityHarajBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}