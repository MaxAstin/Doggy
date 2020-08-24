package com.bunbeauty.doggy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bunbeauty.doggy.R
import com.bunbeauty.doggy.adapter.FavouriteAdapter
import com.bunbeauty.doggy.databinding.ActivityFavouriteBinding
import com.bunbeauty.doggy.di.AppModule
import com.bunbeauty.doggy.di.DaggerAppComponent
import com.bunbeauty.doggy.view_model.FavouriteViewModel
import com.bunbeauty.doggy.view_model.factory.FavouriteViewModelFactory
import kotlinx.android.synthetic.main.activity_favourite.*
import javax.inject.Inject

class FavouriteActivity : AppCompatActivity() {

    @Inject
    lateinit var favouriteViewModelFactory: FavouriteViewModelFactory

    private lateinit var favouriteBinding: ActivityFavouriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.builder()
            .appModule(AppModule(intent, application))
            .build()
            .inject(this)

        favouriteBinding = DataBindingUtil.setContentView(this, R.layout.activity_favourite)

        favouriteListRecyclerView.setHasFixedSize(true)
        favouriteListRecyclerView.layoutManager = LinearLayoutManager(this)
        favouriteListRecyclerView.adapter = FavouriteAdapter()

        favouriteBinding.viewModel = ViewModelProvider(this, favouriteViewModelFactory)
            .get(FavouriteViewModel::class.java)
        favouriteBinding.executePendingBindings()
    }
}