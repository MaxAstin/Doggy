package com.bunbeauty.doggy.model.data

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Favourite::class,
            parentColumns = ["id"],
            childColumns = ["favouriteId"],
            onDelete = CASCADE
        )
    ]
)
data class Photo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val link: String,
    @ColumnInfo(index = true)
    var favouriteId: Long = 0
) : Item {
    @Ignore
    var isLiked: Boolean = false
}