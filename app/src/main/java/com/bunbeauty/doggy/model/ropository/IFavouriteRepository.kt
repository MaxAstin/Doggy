package com.bunbeauty.doggy.model.ropository

import com.bunbeauty.doggy.model.data.Favourite
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.view_model.callback.GetAllFavouritesCallback
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job

interface IFavouriteRepository{
    suspend fun insert(favouriteWithPhotos: FavouriteWithPhotos): Job
    suspend fun getAllFavourites(): Deferred<List<FavouriteWithPhotos>>
}