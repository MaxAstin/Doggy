package com.bunbeauty.doggy.handler

import android.view.View
import com.bunbeauty.doggy.model.data.Photo

interface CheckChangedHandler {

    fun onCheckChanged(photo: Photo, view: View)
}