package com.bunbeauty.doggy.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bunbeauty.doggy.adapter.BreedAdapter
import com.bunbeauty.doggy.adapter.FavouriteAdapter
import com.bunbeauty.doggy.adapter.PhotoAdapter
import com.bunbeauty.doggy.adapter.SubBreedAdapter
import com.bunbeauty.doggy.model.data.Breed
import com.bunbeauty.doggy.model.data.FavouriteWithPhotos
import com.bunbeauty.doggy.model.data.Photo
import com.bunbeauty.doggy.model.data.SubBreed
import com.bunbeauty.doggy.view_model.PhotosViewModel
import com.squareup.picasso.Picasso

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("android:text")
        fun setSubBreeds(textView: TextView, subBreeds:  List<SubBreed>) {
            textView.text = if (subBreeds.isNotEmpty()) {
                "(${subBreeds.size} subbreeds)"
            } else {
                ""
            }
        }

        @JvmStatic
        @BindingAdapter("breed")
        fun setBreed(recyclerView: RecyclerView, breed: Breed) {
            (recyclerView.adapter as? SubBreedAdapter)?.breed = breed
        }

        @JvmStatic
        @BindingAdapter("image")
        fun setImage(imageView: ImageView, photoLink: String) {
            Picasso.get()
                .load(photoLink)
                .resize(300, 300)
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("viewModel")
        fun setPhotosViewModel(viewPager: ViewPager2, viewModel: PhotosViewModel) {
            (viewPager.adapter as? PhotoAdapter)?.viewModel = viewModel
        }

        @JvmStatic
        @BindingAdapter("itemList")
        fun setItemBreedList(recyclerView: RecyclerView, itemList: List<Breed>) {
            (recyclerView.adapter as? BreedAdapter)?.itemList = itemList
        }

        @JvmStatic
        @BindingAdapter("itemList")
        fun setItemSubBreedList(recyclerView: RecyclerView, itemList: List<SubBreed>) {
            (recyclerView.adapter as? SubBreedAdapter)?.itemList = itemList
        }

        @JvmStatic
        @BindingAdapter("itemList")
        fun setItemPhotoList(viewPager: ViewPager2, itemList: List<Photo>) {
            (viewPager.adapter as? PhotoAdapter)?.itemList = itemList
        }

        @JvmStatic
        @BindingAdapter("itemList")
        fun setItemFavouriteList(recyclerView: RecyclerView, itemList: List<FavouriteWithPhotos>) {
            (recyclerView.adapter as? FavouriteAdapter)?.itemList = itemList
        }
    }
}