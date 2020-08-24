package com.bunbeauty.doggy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bunbeauty.doggy.R
import com.bunbeauty.doggy.adapter.SubBreedAdapter
import com.bunbeauty.doggy.databinding.ActivitySubBreedListBinding
import com.bunbeauty.doggy.di.AppModule
import com.bunbeauty.doggy.di.DaggerAppComponent
import com.bunbeauty.doggy.view_model.SubBreedListViewModel
import com.bunbeauty.doggy.view_model.factory.SubBreedListViewModelFactory
import kotlinx.android.synthetic.main.activity_sub_breed_list.*
import javax.inject.Inject

class SubBreedListActivity : AppCompatActivity() {

    @Inject
    lateinit var subBreedListViewModelFactory: SubBreedListViewModelFactory

    private lateinit var subBreedListBinding: ActivitySubBreedListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.builder()
            .appModule(AppModule(intent, application))
            .build()
            .inject(this)

        subBreedListBinding = DataBindingUtil.setContentView(this, R.layout.activity_sub_breed_list)

        subBreedListRecyclerView.setHasFixedSize(true)
        subBreedListRecyclerView.layoutManager = LinearLayoutManager(this)
        subBreedListRecyclerView.adapter = SubBreedAdapter()

        subBreedListBinding.viewModel = ViewModelProvider(this, subBreedListViewModelFactory)
            .get(SubBreedListViewModel::class.java)
        subBreedListBinding.executePendingBindings()
    }
}