package com.bunbeauty.doggy.model.ropository

import android.util.Log
import com.bunbeauty.doggy.model.dao.FavouriteDao
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavouriteRepository(private val favouriteDao: FavouriteDao) : IFavouriteRepository {

    override suspend fun insert(favouriteWithPhotos: FavouriteWithPhotos) =
        withContext(Dispatchers.IO) {
            launch {
                favouriteDao.insert(favouriteWithPhotos)
            }
        }

    override suspend fun getAllFavourites() =
        withContext(Dispatchers.IO) {
            async {
                val a = favouriteDao.getAllFavouriteWithPhotos()
                Log.d("test", "getAllFavourites " + a.size)
                a
            }
        }
}