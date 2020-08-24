package com.bunbeauty.doggy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bunbeauty.doggy.R
import com.bunbeauty.doggy.adapter.BreedAdapter
import com.bunbeauty.doggy.databinding.ActivityBreedListBinding
import com.bunbeauty.doggy.di.AppModule
import com.bunbeauty.doggy.di.DaggerAppComponent
import com.bunbeauty.doggy.view_model.BreedListViewModel
import com.bunbeauty.doggy.view_model.factory.BreedListViewModelFactory
import kotlinx.android.synthetic.main.activity_breed_list.*
import javax.inject.Inject

class BreedListActivity : AppCompatActivity() {

    @Inject
    lateinit var breedListViewModelFactory: BreedListViewModelFactory

    private lateinit var breedListBinding: ActivityBreedListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.builder()
            .appModule(AppModule(intent, application))
            .build()
            .inject(this)

        breedListBinding = DataBindingUtil.setContentView(this, R.layout.activity_breed_list)

        breedListRecyclerView.setHasFixedSize(true)
        breedListRecyclerView.layoutManager = LinearLayoutManager(this)
        breedListRecyclerView.adapter = BreedAdapter()

        breedListBinding.viewModel =
            ViewModelProvider(this, breedListViewModelFactory).get(BreedListViewModel::class.java)
        breedListBinding.executePendingBindings()
    }
}