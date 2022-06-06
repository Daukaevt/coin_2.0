package com.wixsite.mupbam1.resume.coin20

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import com.wixsite.mupbam1.resume.coin20.ui.theme.ItemColumn

@Composable
fun LazyColumnDemo(coinDataList:MutableList<coin_dataItem>) {
    val colorKingBlue= colorResource(id = R.color.KingBlue)
    val colorBlue= colorResource(id = R.color.blue)
    Log.d(MyLog, "coinDataList.toString()$coinDataList")

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        //       .background(color = colorResource(R.color.KingBlue))
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    colorKingBlue,
                    colorBlue
                )
            )
        )
    ) {
        items(items = coinDataList, itemContent = { item ->
            ItemColumn(coinDataitem = item)

        })
    }
}