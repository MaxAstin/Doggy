package com.bunbeauty.doggy.view_model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.bunbeauty.doggy.model.data.Breed
import com.bunbeauty.doggy.model.data.SubBreed
import com.bunbeauty.doggy.model.ropository.IBreedRepository
import com.bunbeauty.doggy.view_model.callback.GetAllBreedsCallback

class BreedListViewModel(private val breedRepository: IBreedRepository) : ViewModel() {

    val gottenBreeds = ObservableField<List<Breed>>(arrayListOf())
    val isLoading = ObservableField<Boolean>()

    init {
        getAllBreeds()
    }

    private fun getAllBreeds() {
        isLoading.set(true)
        breedRepository.getAll(object : GetAllBreedsCallback {
            override fun onAllBreedsGotten(breedsMap: Map<String, List<String>>) {
                isLoading.set(false)
                val breeds = breedsMap.map {
                    val subBreeds = it.value.map { subBreed -> SubBreed(subBreed) }
                    Breed(name = it.key, subBreads = subBreeds)
                }
                gottenBreeds.set(breeds)
            }
        })
    }
}