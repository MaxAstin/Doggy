package com.bunbeauty.doggy.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bunbeauty.doggy.model.data.Item

abstract class BaseAdapter<T : RecyclerView.ViewHolder, E : Item> : RecyclerView.Adapter<T>() {

    var itemList: List<E> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return itemList.size
    }
}