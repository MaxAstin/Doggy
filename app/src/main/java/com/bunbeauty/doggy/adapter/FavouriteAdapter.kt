package com.bunbeauty.doggy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bunbeauty.doggy.databinding.ItemFavourtieBinding
import com.bunbeauty.doggy.handler.FavouriteClickHandler
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos.CREATOR.FAVOURITE_EXTRA
import com.bunbeauty.doggy.view.PhotosActivity

class FavouriteAdapter :
    BaseAdapter<FavouriteAdapter.FavouriteItemViewHolder, FavouriteWithPhotos>(),
    FavouriteClickHandler {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFavourtieBinding.inflate(inflater, parent, false)
        binding.context = parent.context

        return FavouriteItemViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: FavouriteItemViewHolder, position: Int) {
        holder.binding.favouriteWithPhotos = itemList[position]
        holder.binding.favouriteClickHandler = this
    }

    override fun clickToFavourite(favouriteWithPhotos: FavouriteWithPhotos, context: Context) {
        val intent = Intent(context, PhotosActivity::class.java).apply {
            putExtra(FAVOURITE_EXTRA, favouriteWithPhotos)
        }
        context.startActivity(intent)
    }

    inner class FavouriteItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemFavourtieBinding = DataBindingUtil.bind(itemView)!!
    }
}