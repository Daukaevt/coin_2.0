package com.wixsite.mupbam1.resume.coin20.retrofitApi


import com.wixsite.mupbam1.resume.coin20.Const.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Create Service
    val service = retrofit.create(ApiGetResponse::class.java)
}