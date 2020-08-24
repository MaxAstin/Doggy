package com.bunbeauty.doggy.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favourite(
    @PrimaryKey
    val id: Long = 0,
    val name: String
)