package com.wixsite.mupbam1.resume.coin20

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import com.wixsite.mupbam1.resume.coin20.retrofitApi.ApiService
import com.wixsite.mupbam1.resume.coin20.ui.theme.Coin20Theme
import com.wixsite.mupbam1.resume.coin20.ui.theme.ItemColumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://api.coingecko.com"
const val MyLog="MyLog"

class MainActivity : ComponentActivity() {

    private val coinDataList: MutableList<coin_dataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var network = isNetworkAvailable(this)
        if (network==false){

            Toast.makeText(this, getString(R.string.noNetwork), Toast.LENGTH_SHORT).show()
        }else{
            parseGson()
        }
    }

    fun isNetworkAvailable(context: Context): Boolean {
        // Network chek
        val connectivityManager = context.getApplicationContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    private fun parseGson() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        // Create Service
        val service = retrofit.create(ApiService::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.getData()


            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val items = response.body()

                    if (items != null) {
                        coinDataList.addAll(items)

                        for (i in 0 until items.count()) {
                            // Name
                            val name = items[i].name
                           // Log.d(MyLog, name)

                            // current_price
                            val current_price = items[i].current_price
                           // Log.d(MyLog, current_price.toString())

                            // image
                            val image = items[i].image
                           // Log.d(MyLog, image)

                            setContent {
                                LazyColumnDemo(coinDataList)

                            }

                        }
                    }

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}

@Composable
fun LazyColumnDemo(coinDataList:MutableList<coin_dataItem>) {
    Log.d(MyLog, "coinDataList.toString()$coinDataList")

    LazyColumn(modifier = Modifier.fillMaxWidth()
        .background(color = colorResource(R.color.KingBlue))
    ) {
        items(items = coinDataList, itemContent = { item ->
            ItemColumn(coinDataitem = item)

        })
    }
}


