package com.bunbeauty.doggy.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.bunbeauty.doggy.model.data.Favourite
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.model.data.Photo

@Dao
interface FavouriteDao {

    @Transaction
    fun insert(favouriteWithPhotos: FavouriteWithPhotos): FavouriteWithPhotos {
        val favouriteId = insert(favouriteWithPhotos.favourite)
        for (photo in favouriteWithPhotos.photoList) {
            photo.favouriteId = favouriteId
            insert(photo)
        }

        return favouriteWithPhotos
    }

    @Insert
    fun insert(favourite: Favourite): Long

    @Insert
    fun insert(photo: Photo): Long

    @Transaction
    @Query("SELECT * FROM Favourite")
    fun getAllFavouriteWithPhotos(): List<FavouriteWithPhotos>
}