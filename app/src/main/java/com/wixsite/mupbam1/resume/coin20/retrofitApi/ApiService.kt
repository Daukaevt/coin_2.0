package com.wixsite.mupbam1.resume.coin20.retrofitApi

import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v3/coins/markets?vs_currency=usd")
    suspend fun getData(): Response<List<coin_dataItem>>
}