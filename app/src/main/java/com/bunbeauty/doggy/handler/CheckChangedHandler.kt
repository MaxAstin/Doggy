package com.bunbeauty.doggy.handler

import com.bunbeauty.doggy.model.data.Photo

interface CheckChangedHandler {

    fun onCheckChanged(photo: Photo, isChecked: Boolean)
}