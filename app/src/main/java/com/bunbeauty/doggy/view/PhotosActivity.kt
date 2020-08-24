package com.bunbeauty.doggy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bunbeauty.doggy.R
import com.bunbeauty.doggy.adapter.PhotoAdapter
import com.bunbeauty.doggy.databinding.ActivityPhotosBinding
import com.bunbeauty.doggy.di.AppModule
import com.bunbeauty.doggy.di.DaggerAppComponent
import com.bunbeauty.doggy.view_model.PhotosViewModel
import com.bunbeauty.doggy.view_model.factory.PhotosViewModelFactory
import kotlinx.android.synthetic.main.activity_photos.*
import javax.inject.Inject

class PhotosActivity : AppCompatActivity() {

    @Inject
    lateinit var photosViewModelFactory: PhotosViewModelFactory

    private lateinit var photosBinding: ActivityPhotosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.builder()
            .appModule(AppModule(intent, application))
            .build()
            .inject(this)

        photosBinding = DataBindingUtil.setContentView(this, R.layout.activity_photos)

        photosViewPager.adapter = PhotoAdapter()

        photosBinding.viewModel =
            ViewModelProvider(this, photosViewModelFactory).get(PhotosViewModel::class.java)
        photosBinding.executePendingBindings()
    }
}