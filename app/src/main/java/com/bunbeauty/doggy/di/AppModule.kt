package com.bunbeauty.doggy.di

import android.app.Application
import android.content.Intent
import androidx.room.Room
import com.bunbeauty.doggy.model.LocalDatabase
import com.bunbeauty.doggy.model.dao.FavouriteDao
import com.bunbeauty.doggy.model.ropository.BreedRepository
import com.bunbeauty.doggy.model.ropository.FavouriteRepository
import com.bunbeauty.doggy.view_model.factory.BreedListViewModelFactory
import com.bunbeauty.doggy.view_model.factory.FavouriteViewModelFactory
import com.bunbeauty.doggy.view_model.factory.PhotosViewModelFactory
import com.bunbeauty.doggy.view_model.factory.SubBreedListViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val intent: Intent, private val application: Application) {

    // factories

    @Provides
    fun providePhotoViewModelFactory(breedRepository: BreedRepository) =
        PhotosViewModelFactory(intent, breedRepository)

    @Provides
    fun provideBreedListViewModelFactory(breedRepository: BreedRepository) =
        BreedListViewModelFactory(breedRepository)

    @Provides
    fun provideSubBreedListViewModelFactory() = SubBreedListViewModelFactory(intent)

    @Provides
    fun provideFavouriteViewModelFactory(favouriteRepository: FavouriteRepository) =
        FavouriteViewModelFactory(favouriteRepository)

    // repositories

    @Provides
    fun provideBreedRepository() = BreedRepository()

    @Provides
    fun provideFavouriteRepository(favouriteDao: FavouriteDao) = FavouriteRepository(favouriteDao)

    // DAO

    @Provides
    @Singleton
    fun provideLocalDatabase(): LocalDatabase {
        return synchronized(this) {
            Room.databaseBuilder(
                application.applicationContext,
                LocalDatabase::class.java,
                "LocalDatabase"
            ).fallbackToDestructiveMigration().build()
        }
    }

    @Provides
    fun provideFavouriteDao(localDatabase: LocalDatabase) = localDatabase.getFavouriteDao()


}
