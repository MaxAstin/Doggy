package com.bunbeauty.doggy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bunbeauty.doggy.model.data.Breed
import com.bunbeauty.doggy.databinding.ItemBreedBinding
import com.bunbeauty.doggy.handler.BreedClickHandler
import com.bunbeauty.doggy.view.PhotosActivity
import com.bunbeauty.doggy.view.SubBreedListActivity

class BreedAdapter : BaseAdapter<BreedAdapter.BreedItemViewHolder, Breed>(), BreedClickHandler {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBreedBinding.inflate(inflater, parent, false)
        binding.context = parent.context

        return BreedItemViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: BreedItemViewHolder, position: Int) {
        holder.binding.breed = itemList[position]
        holder.binding.breedClickHandler = this
    }

    override fun clickToBreedWithoutSubBreeds(breed: Breed, context: Context) {
        val intent = Intent(context, PhotosActivity::class.java).apply {
            putExtra(Breed.BREED_EXTRA, breed)
        }
        context.startActivity(intent)
    }

    override fun clickToBreedWithSubBreeds(breed: Breed, context: Context) {
        val intent = Intent(context, SubBreedListActivity::class.java).apply {
            putExtra(Breed.BREED_EXTRA, breed)
        }
        context.startActivity(intent)
    }

    inner class BreedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemBreedBinding = DataBindingUtil.bind(itemView)!!
    }
}