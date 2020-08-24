package com.bunbeauty.doggy.view_model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bunbeauty.doggy.model.ropository.IFavouriteRepository

class FavouriteViewModelFactory(private val favouriteRepository: IFavouriteRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(IFavouriteRepository::class.java)
            .newInstance(favouriteRepository)
    }
}