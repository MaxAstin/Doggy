package com.bunbeauty.doggy.model.data

import android.os.Parcel
import android.os.Parcelable

data class Breed(
    var id: Long = 0,
    var name: String,
    var subBreads: List<SubBreed>
) : Parcelable, Item {

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readArrayList(SubBreed::class.java.classLoader)!! as ArrayList<SubBreed>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeList(subBreads)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Breed> {

        const val BREED_EXTRA = "breed extra"

        override fun createFromParcel(parcel: Parcel): Breed {
            return Breed(parcel)
        }

        override fun newArray(size: Int): Array<Breed?> {
            return arrayOfNulls(size)
        }
    }
}