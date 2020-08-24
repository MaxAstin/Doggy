package com.bunbeauty.doggy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bunbeauty.doggy.databinding.ItemPhotoBinding
import com.bunbeauty.doggy.handler.CheckChangedHandler
import com.bunbeauty.doggy.model.data.Photo
import com.bunbeauty.doggy.view_model.PhotosViewModel

class PhotoAdapter : BaseAdapter<PhotoAdapter.PhotoViewHolder, Photo>(), CheckChangedHandler {

    lateinit var viewModel: PhotosViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(inflater, parent, false)

        return PhotoViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binding.photo = itemList[position]
        holder.binding.checkChangedHandler = this
    }

    override fun onCheckChanged(photo: Photo, isChecked: Boolean) {
        if (isChecked) {
            viewModel.addPhotoLinkToFavorite(photo)
        } else {
            viewModel.removePhotoLinkFromFavorite(photo)
        }

        photo.isLiked = isChecked
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemPhotoBinding = DataBindingUtil.bind(itemView)!!
    }
}