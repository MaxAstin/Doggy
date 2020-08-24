package com.bunbeauty.doggy.model.data

data class BreedsResponse(
    val message: Map<String, List<String>>,
    val status: String
)