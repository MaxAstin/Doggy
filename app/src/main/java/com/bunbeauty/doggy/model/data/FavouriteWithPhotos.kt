package com.bunbeauty.doggy.model.data

import androidx.room.Embedded
import androidx.room.Relation
import java.io.Serializable

data class FavouriteWithPhotos(
    @Embedded
    val favourite: Favourite,

    @Relation(parentColumn = "id", entity = Photo::class, entityColumn = "favouriteId")
    val photoList: MutableList<Photo>
) : Serializable, Item {

    companion object {
        const val FAVOURITE_EXTRA = "favourite extra"
    }
}