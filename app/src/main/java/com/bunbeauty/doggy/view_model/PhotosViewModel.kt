package com.bunbeauty.doggy.view_model

import android.content.Intent
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bunbeauty.doggy.model.data.*
import com.bunbeauty.doggy.model.ropository.IBreedRepository
import com.bunbeauty.doggy.model.ropository.IFavouriteRepository
import com.bunbeauty.doggy.view_model.callback.GetPhotosCallback
import kotlinx.coroutines.launch

class PhotosViewModel(
    private val intent: Intent,
    private val breedRepository: IBreedRepository,
    private val favouriteRepository: IFavouriteRepository
) : ViewModel() {

    val gottenPhotoList = ObservableField<List<Photo>>(arrayListOf())
    val isLoading = ObservableField<Boolean>()
    private val favourite: FavouriteWithPhotos = getFavorite()

    init {
        getPhotoLinkList()
    }

    private fun getFavorite(): FavouriteWithPhotos {
        return if (getSubBreedName() == null) {
            FavouriteWithPhotos(Favourite(name = getBreedName()), arrayListOf())
        } else {
            FavouriteWithPhotos(Favourite(name = getSubBreedName()!!), arrayListOf())
        }
    }

    private fun getPhotoLinkList() {
        if (getSubBreedName() == null) {
            getPhotoLinkListByBreed(getBreedName())
        } else {
            getPhotoLinkListBySubBreed(getBreedName(), getSubBreedName()!!)
        }
    }

    private fun getBreedName(): String {
        return intent.getParcelableExtra<Breed>(Breed.BREED_EXTRA)!!.name
    }

    private fun getSubBreedName(): String? {
        return (intent.getParcelableExtra(SubBreed.SUB_BREED_EXTRA) as? SubBreed)?.subBreed
    }

    private fun getPhotoLinkListBySubBreed(breedName: String, subBreed: String) {
        isLoading.set(true)
        breedRepository.getPhotosBySubBreed(breedName, subBreed, object : GetPhotosCallback {
            override fun onPhotosGotten(photoList: List<Photo>) {
                isLoading.set(false)
                gottenPhotoList.set(photoList)
            }
        })
    }

    private fun getPhotoLinkListByBreed(breedName: String) {
        isLoading.set(true)
        breedRepository.getPhotosByBreed(breedName, object : GetPhotosCallback {
            override fun onPhotosGotten(photoList: List<Photo>) {
                isLoading.set(false)
                gottenPhotoList.set(photoList)
            }
        })
    }

    fun addPhotoLinkToFavorite(photo: Photo) {
        favourite.photoList.add(photo)
        viewModelScope.launch {
            favouriteRepository.insert(favourite)
        }
    }

    fun removePhotoLinkFromFavorite(photo: Photo) {
        favourite.photoList.remove(photo)
        //favouriteRepository.insert(favourite)
    }
}