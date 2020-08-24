package com.bunbeauty.doggy.model.ropository

import com.bunbeauty.doggy.view_model.callback.GetAllBreedsCallback
import com.bunbeauty.doggy.view_model.callback.GetPhotosCallback

interface IBreedRepository {

    fun getAll(getAllBreedsCallback: GetAllBreedsCallback)
    fun getPhotosBySubBreed(
        breedName: String,
        subBreed: String,
        getPhotosCallback: GetPhotosCallback
    )
    fun getPhotosByBreed(breedName: String, getPhotosCallback: GetPhotosCallback)
}