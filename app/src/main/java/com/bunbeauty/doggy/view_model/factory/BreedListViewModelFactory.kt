package com.bunbeauty.doggy.view_model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bunbeauty.doggy.model.ropository.IBreedRepository

class BreedListViewModelFactory(private val breedRepository: IBreedRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass
            .getConstructor(IBreedRepository::class.java)
            .newInstance(breedRepository)

}