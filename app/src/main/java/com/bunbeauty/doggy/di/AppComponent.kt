package com.bunbeauty.doggy.di

import com.bunbeauty.doggy.view.BreedListActivity
import com.bunbeauty.doggy.view.FavouriteActivity
import com.bunbeauty.doggy.view.PhotosActivity
import com.bunbeauty.doggy.view.SubBreedListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(breedListActivity: BreedListActivity)
    fun inject(subBreedListActivity: SubBreedListActivity)
    fun inject(photosActivity: PhotosActivity)
    fun inject(favouriteActivity: FavouriteActivity)
}