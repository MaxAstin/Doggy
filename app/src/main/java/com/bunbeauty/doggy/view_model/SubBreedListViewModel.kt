package com.bunbeauty.doggy.view_model

import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.bunbeauty.doggy.model.data.Breed

class SubBreedListViewModel(private val intent: Intent) : ViewModel() {

    val breed = ObservableField<Breed>()

    init {
        breed.set(getBreed())
    }

    private fun getBreed(): Breed {
        return intent.getParcelableExtra(Breed.BREED_EXTRA)!!
    }
}