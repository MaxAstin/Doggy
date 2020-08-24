package com.bunbeauty.doggy.view_model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.model.ropository.IFavouriteRepository
import com.bunbeauty.doggy.view_model.callback.GetAllFavouritesCallback

class FavouriteViewModel(private val favouriteRepository: IFavouriteRepository): ViewModel() {

    val gottenFavouriteList = ObservableField<List<FavouriteWithPhotos>>(arrayListOf())

    init {
        getFavourites()
    }

    private fun getFavourites() {
        favouriteRepository.getAllFavourites(object : GetAllFavouritesCallback {
            override fun onAllFavouritesGotten(favouriteList: List<FavouriteWithPhotos>) {
                gottenFavouriteList.set(favouriteList)
            }
        })
    }
}