package com.bunbeauty.doggy.handler

import android.content.Context
import com.bunbeauty.doggy.model.data.Breed

interface BreedClickHandler {
    fun clickToBreedWithSubBreeds(breed: Breed, context: Context)
    fun clickToBreedWithoutSubBreeds(breed: Breed, context: Context)
}