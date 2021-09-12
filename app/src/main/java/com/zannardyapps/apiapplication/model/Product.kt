package com.zannardyapps.apiapplication.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    var id: String,
    @SerializedName("prname")
    var prName: String,
    @SerializedName("primage")
    var prImage: String,
    @SerializedName("prprice")
    var prPrice: String,
)
