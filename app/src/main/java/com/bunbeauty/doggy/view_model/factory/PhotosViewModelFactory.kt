package com.bunbeauty.doggy.view_model.factory

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bunbeauty.doggy.model.ropository.IBreedRepository

class PhotosViewModelFactory(
    private val intent: Intent,
    private val breedRepository: IBreedRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass
            .getConstructor(Intent::class.java, IBreedRepository::class.java)
            .newInstance(intent, breedRepository)
}