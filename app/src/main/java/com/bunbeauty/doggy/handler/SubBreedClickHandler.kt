package com.bunbeauty.doggy.handler

import android.content.Context
import com.bunbeauty.doggy.model.data.Breed
import com.bunbeauty.doggy.model.data.SubBreed

interface SubBreedClickHandler {
    fun click(breed: Breed, subBreed: SubBreed, context: Context)
}