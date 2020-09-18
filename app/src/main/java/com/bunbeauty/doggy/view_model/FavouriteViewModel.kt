package com.bunbeauty.doggy.view_model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.model.ropository.IFavouriteRepository
import kotlinx.coroutines.launch

class FavouriteViewModel(private val favouriteRepository: IFavouriteRepository): ViewModel() {

    val gottenFavouriteList = ObservableField<List<FavouriteWithPhotos>>(arrayListOf())

    init {
        getFavourites()
    }

    private fun getFavourites() {
        viewModelScope.launch {
            gottenFavouriteList.set(favouriteRepository.getAllFavourites().await())
        }
    }
}