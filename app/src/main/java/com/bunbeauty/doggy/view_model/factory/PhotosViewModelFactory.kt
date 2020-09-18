package com.bunbeauty.doggy.view_model.factory

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bunbeauty.doggy.model.ropository.IBreedRepository
import com.bunbeauty.doggy.model.ropository.IFavouriteRepository

class PhotosViewModelFactory(
    private val intent: Intent,
    private val breedRepository: IBreedRepository,
    private val favouriteRepository: IFavouriteRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            Intent::class.java,
            IBreedRepository::class.java,
            IFavouriteRepository::class.java
        ).newInstance(intent, breedRepository, favouriteRepository)
}