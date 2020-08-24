package com.bunbeauty.doggy.model.ropository

import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.view_model.callback.GetAllFavouritesCallback

interface IFavouriteRepository{
    fun insertFavourite(favouriteWithPhotos: FavouriteWithPhotos)
    fun getAllFavourites(getAllFavouritesCallback: GetAllFavouritesCallback)
}