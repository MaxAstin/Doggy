package com.bunbeauty.doggy.model.ropository

import android.util.Log
import com.bunbeauty.doggy.api.DogApiService
import com.bunbeauty.doggy.model.data.BreedsResponse
import com.bunbeauty.doggy.model.data.Photo
import com.bunbeauty.doggy.model.data.PhotosResponse
import com.bunbeauty.doggy.view_model.callback.GetAllBreedsCallback
import com.bunbeauty.doggy.view_model.callback.GetPhotosCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BreedRepository : IBreedRepository {

    override fun getAll(getAllBreedsCallback: GetAllBreedsCallback) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DogApiService::class.java)
        service.getAllBreeds().enqueue(object : Callback<BreedsResponse> {

            override fun onResponse(
                call: Call<BreedsResponse>,
                response: Response<BreedsResponse>
            ) {
                getAllBreedsCallback.onAllBreedsGotten(response.body()!!.message)
            }

            override fun onFailure(call: Call<BreedsResponse>, t: Throwable) {
                Log.d("test", "Error: " + t.message)
            }
        })
    }

    override fun getPhotosBySubBreed(
        breedName: String,
        subBreed: String,
        getPhotosCallback: GetPhotosCallback
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(DogApiService::class.java)
        service.getPhotosBySubBreed(breedName, subBreed).enqueue(object : Callback<PhotosResponse> {

            override fun onResponse(
                call: Call<PhotosResponse>,
                response: Response<PhotosResponse>
            ) {
                val photoList = response.body()!!.message.map { Photo(link = it) }
                getPhotosCallback.onPhotosGotten(photoList)
            }

            override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                Log.d("test", "Error: " + t.message)
            }
        })
    }

    override fun getPhotosByBreed(breedName: String, getPhotosCallback: GetPhotosCallback) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(DogApiService::class.java)
        service.getPhotosByBreed(breedName).enqueue(object : Callback<PhotosResponse> {

            override fun onResponse(
                call: Call<PhotosResponse>,
                response: Response<PhotosResponse>
            ) {
                val photoList = response.body()!!.message.map { Photo(link = it) }
                getPhotosCallback.onPhotosGotten(photoList)
            }

            override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                Log.d("test", "Error: " + t.message)
            }
        })
    }

    companion object {
        private const val BASE_URL = "https://dog.ceo/api/"
    }
}