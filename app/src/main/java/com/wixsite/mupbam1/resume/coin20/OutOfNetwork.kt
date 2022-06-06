package com.wixsite.mupbam1.resume.coin20

import android.content.Context
import android.net.ConnectivityManager
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import com.wixsite.mupbam1.resume.coin20.retrofitApi.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class OutOfNetwork() {
    fun isNetworkAvailable(context: Context): Boolean {
        // Network chek
        val connectivityManager = context.getApplicationContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}
