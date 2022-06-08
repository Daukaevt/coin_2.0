package com.wixsite.mupbam1.resume.coin20

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.wixsite.mupbam1.resume.coin20.ui.theme.Salad
import com.wixsite.mupbam1.resume.coin20.ui.theme.White
import com.wixsite.mupbam1.resume.coin20.ui.theme.Yellow

object Const {
    const val BASE_URL="https://api.coingecko.com"
    const val endPoint="/api/v3/coins/markets?vs_currency=usd"
    const val MyLog="MyLog"
    const val DecimalFormat="#0.00"
    val padding = 4.dp
    val ColorSalad = Salad
    val ColorYellow = Yellow
    val elevation = 5.dp
    val imageSize = 64.dp
    val imagePadding = 3.dp
}