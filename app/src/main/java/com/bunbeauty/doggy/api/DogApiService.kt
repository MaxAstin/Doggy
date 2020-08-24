package com.bunbeauty.doggy.api

import com.bunbeauty.doggy.model.data.BreedsResponse
import com.bunbeauty.doggy.model.data.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiService {

    @GET("breeds/list/all")
    fun getAllBreeds(): Call<BreedsResponse>

    @GET("breed/{breedName}/{subBreed}/images")
    fun getPhotosBySubBreed(
        @Path("breedName") breedName: String,
        @Path("subBreed") subBreed: String
    ): Call<PhotosResponse>

    @GET("breed/{breedName}/images")
    fun getPhotosByBreed(@Path("breedName")  breedName: String): Call<PhotosResponse>
}