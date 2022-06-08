package com.wixsite.mupbam1.resume.coin20

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import com.wixsite.mupbam1.resume.coin20.retrofitApi.RetrofitService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


val coinDataList: MutableList<coin_dataItem> = mutableListOf()
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val outOfNetwork=OutOfNetwork()
       var network = outOfNetwork.isNetworkAvailable(this)

        if (network==false){
            Toast.makeText(this, getString(R.string.noNetwork), Toast.LENGTH_SHORT).show()
        }else{
                parseGson()
        }
    }

    private fun parseGson() {

        val service=RetrofitService().service

        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.getData()


            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val items = response.body()

                    if (items != null) {
                        coinDataList.addAll(items)
                        setContent {
                                LazyColumnDemo(coinDataList)
                          }
//                        for (i in 0 until items.count()) {
//                            // Name
//                            val name = items[i].name
//                           // Log.d(MyLog, name)
//
//                            // current_price
//                            val current_price = items[i].current_price
//                           // Log.d(MyLog, current_price.toString())
//
//                            // image
//                            val image = items[i].image
//                           // Log.d(MyLog, image)
//                        }
                    }

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}




