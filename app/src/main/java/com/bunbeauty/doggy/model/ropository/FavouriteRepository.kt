package com.bunbeauty.doggy.model.ropository

import com.bunbeauty.doggy.model.dao.FavouriteDao
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.view_model.callback.GetAllFavouritesCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteRepository(private val favouriteDao: FavouriteDao) : IFavouriteRepository {

    override fun insertFavourite(favouriteWithPhotos: FavouriteWithPhotos) {
        CoroutineScope(Dispatchers.Main).launch {
            favouriteDao.insert(favouriteWithPhotos)
        }
    }

    override fun getAllFavourites(getAllFavouritesCallback: GetAllFavouritesCallback) {
        CoroutineScope(Dispatchers.Main).launch {
            val favouritesList = favouriteDao.getAllFavouriteWithPhotos()
            getAllFavouritesCallback.onAllFavouritesGotten(favouritesList)
        }
    }
}