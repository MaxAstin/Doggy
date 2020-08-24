package com.bunbeauty.doggy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bunbeauty.doggy.model.data.Breed
import com.bunbeauty.doggy.databinding.ItemSubBreedBinding
import com.bunbeauty.doggy.handler.SubBreedClickHandler
import com.bunbeauty.doggy.model.data.SubBreed
import com.bunbeauty.doggy.view.PhotosActivity

class SubBreedAdapter : BaseAdapter<SubBreedAdapter.SubBreedItemViewHolder, SubBreed>(),
    SubBreedClickHandler {

    lateinit var breed: Breed

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubBreedItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSubBreedBinding.inflate(inflater, parent, false)
        binding.context = parent.context

        return SubBreedItemViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: SubBreedItemViewHolder, position: Int) {
        holder.binding.subBreed = itemList[position]
        holder.binding.subBreedClickHandler = this
        holder.binding.breed = breed
    }

    override fun click(breed: Breed, subBreed: SubBreed, context: Context) {
        val intent = Intent(context, PhotosActivity::class.java).apply {
            putExtra(Breed.BREED_EXTRA, breed)
            putExtra(SubBreed.SUB_BREED_EXTRA, subBreed)
        }
        context.startActivity(intent)
    }

    inner class SubBreedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemSubBreedBinding = DataBindingUtil.bind(itemView)!!
    }
}