package com.bunbeauty.doggy.view_model.callback

interface GetAllBreedsCallback {

    fun onAllBreedsGotten(breedsMap: Map<String, List<String>>)
}