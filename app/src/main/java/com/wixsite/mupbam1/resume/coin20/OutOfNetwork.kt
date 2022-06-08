package com.wixsite.mupbam1.resume.coin20

import android.content.Context
import android.net.ConnectivityManager


class OutOfNetwork() {
    fun isNetworkAvailable(context: Context): Boolean {
        // Network chek
        val connectivityManager = context.getApplicationContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}
