package com.bunbeauty.doggy.handler

import android.content.Context
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos

interface FavouriteClickHandler {

    fun clickToFavourite(favouriteWithPhotos: FavouriteWithPhotos, context: Context)
}