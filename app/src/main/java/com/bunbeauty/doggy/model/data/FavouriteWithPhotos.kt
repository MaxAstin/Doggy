package com.bunbeauty.doggy.model.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation

data class FavouriteWithPhotos(
    @Embedded
    val favourite: Favourite,

    @Relation(parentColumn = "id", entity = Photo::class, entityColumn = "favouriteId")
    val photoList: MutableList<Photo>
) : Parcelable, Item {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable<Favourite>(Favourite::class.java.classLoader)!!,
        parcel.readArrayList(Photo::class.java.classLoader) as ArrayList<Photo>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(favourite, flags)
        parcel.writeList(photoList as List<Photo>)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FavouriteWithPhotos> {
        override fun createFromParcel(parcel: Parcel): FavouriteWithPhotos {
            return FavouriteWithPhotos(parcel)
        }

        override fun newArray(size: Int): Array<FavouriteWithPhotos?> {
            return arrayOfNulls(size)
        }

        const val FAVOURITE_EXTRA = "favourite extra"
    }
}