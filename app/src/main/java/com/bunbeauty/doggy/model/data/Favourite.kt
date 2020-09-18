package com.bunbeauty.doggy.model.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favourite(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Favourite> {
        override fun createFromParcel(parcel: Parcel): Favourite {
            return Favourite(parcel)
        }

        override fun newArray(size: Int): Array<Favourite?> {
            return arrayOfNulls(size)
        }
    }

}