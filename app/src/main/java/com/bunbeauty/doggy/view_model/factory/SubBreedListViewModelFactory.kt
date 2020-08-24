package com.bunbeauty.doggy.view_model.factory

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SubBreedListViewModelFactory(private val intent: Intent) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass
            .getConstructor(Intent::class.java)
            .newInstance(intent)

}