package com.bunbeauty.doggy.view_model.callback

import com.bunbeauty.doggy.model.data.Photo

interface GetPhotosCallback {
    fun onPhotosGotten(photoList: List<Photo>)
}