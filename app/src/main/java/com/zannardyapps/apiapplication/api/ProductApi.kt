package com.zannardyapps.apiapplication.api

import com.zannardyapps.apiapplication.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApi {
    @GET("getdata.php")
    fun getProductApi(): Call<List<Product>>
}
