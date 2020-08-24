package com.bunbeauty.doggy.view_model.callback

import com.bunbeauty.doggy.model.data.FavouriteWithPhotos

interface GetAllFavouritesCallback {
    fun onAllFavouritesGotten(favouriteList: List<FavouriteWithPhotos>)
}