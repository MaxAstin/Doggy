package com.bunbeauty.doggy.di

import android.app.Application
import android.content.Intent
import androidx.room.Room
import com.bunbeauty.doggy.model.LocalDatabase
import com.bunbeauty.doggy.model.dao.FavouriteDao
import com.bunbeauty.doggy.model.ropository.BreedRepository
import com.bunbeauty.doggy.model.ropository.FavouriteRepository
import com.bunbeauty.doggy.model.ropository.IBreedRepository
import com.bunbeauty.doggy.model.ropository.IFavouriteRepository
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
    fun providePhotoViewModelFactory(
        breedRepository: IBreedRepository,
        favouriteRepository: IFavouriteRepository
    ) =
        PhotosViewModelFactory(intent, breedRepository, favouriteRepository)

    @Provides
    fun provideBreedListViewModelFactory(breedRepository: IBreedRepository) =
        BreedListViewModelFactory(breedRepository)

    @Provides
    fun provideSubBreedListViewModelFactory() = SubBreedListViewModelFactory(intent)

    @Provides
    fun provideFavouriteViewModelFactory(favouriteRepository: IFavouriteRepository) =
        FavouriteViewModelFactory(favouriteRepository)

    // repositories

    @Provides
    fun provideBreedRepository(): IBreedRepository = BreedRepository()

    @Provides
    fun provideFavouriteRepository(favouriteDao: FavouriteDao): IFavouriteRepository =
        FavouriteRepository(favouriteDao)

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
