package com.bunbeauty.doggy.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bunbeauty.doggy.model.dao.FavouriteDao
import com.bunbeauty.doggy.model.data.Favourite
import com.bunbeauty.doggy.model.data.Photo

@Database(
    entities = [Photo::class, Favourite::class],
    version = 5
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getFavouriteDao(): FavouriteDao
}