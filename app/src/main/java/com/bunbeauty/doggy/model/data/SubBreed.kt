package com.bunbeauty.doggy.model.data

import android.os.Parcel
import android.os.Parcelable

data class SubBreed(
    val subBreed: String = ""
) : Item, Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(subBreed)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubBreed> {
        const val SUB_BREED_EXTRA = "sub breed extra"

        override fun createFromParcel(parcel: Parcel): SubBreed {
            return SubBreed(parcel)
        }

        override fun newArray(size: Int): Array<SubBreed?> {
            return arrayOfNulls(size)
        }
    }
}