package com.wixsite.mupbam1.resume.coin20.ui.theme


import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import com.wixsite.mupbam1.resume.coin20.Const
import com.wixsite.mupbam1.resume.coin20.Const.DecimalFormat
import com.wixsite.mupbam1.resume.coin20.Const.elevation
import com.wixsite.mupbam1.resume.coin20.Const.imagePadding
import com.wixsite.mupbam1.resume.coin20.Const.imageSize
import com.wixsite.mupbam1.resume.coin20.Const.padding
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import java.text.DecimalFormat



@Composable
fun ItemColumn(coinDataitem: coin_dataItem) {

       var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { isExpanded = !isExpanded }
        .padding(padding),
        shape = Shapes.large,
        elevation = elevation

    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Const.ColorSalad,
                        Const.ColorYellow
                    )
                )
            )
        ) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(coinDataitem.image),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(imageSize)
                            .padding(imagePadding)
                    )
                    Column(
                        modifier = Modifier.padding(padding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = coinDataitem.name,
                            color = KingBlue,
                            fontSize = Typography.body2.fontSize,
                            fontWeight = Typography.body2.fontWeight,
                            fontFamily = Typography.body2.fontFamily,

                        )

                        Text(
                            text = coinDataitem.current_price.toString(),
                            fontSize = Typography.caption.fontSize,
                            fontStyle = Typography.caption.fontStyle,
                            // fontWeight = FontWeight.Bold
                        )

                    }
                    Column(modifier = Modifier.padding(padding)) {
                        val price_change_percentage = coinDataitem.price_change_percentage_24h
                        var textColor= Green
                        if (price_change_percentage<0){
                            textColor= Red
                        }
                        val formattedDouble: String =
                            DecimalFormat(DecimalFormat).format(price_change_percentage)
                        Text(
                            text = formattedDouble + "%",
                            color = textColor,
                            textAlign = TextAlign.Right,
                            fontSize = Typography.body2.fontSize,
                            fontFamily = Typography.body2.fontFamily
                        )
                    }
                }
                if (isExpanded) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .padding(padding)
                                .clip(Shapes.large)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Const.ColorSalad,
                                            Const.ColorYellow
                                        )
                                    )
                                )
                        ) {
                            Text(
                                text =
                                " All-time high price: ${coinDataitem.ath} (${coinDataitem.ath_change_percentage.toInt()}%) \n" +
                                        "at ${coinDataitem.ath_date} \n" +
                                        "\n" +
                                        "All-time high price: ${coinDataitem.atl} (${coinDataitem.atl_change_percentage.toInt()}%) \n" +
                                        "at ${coinDataitem.atl_date} \n" +
                                        "\n" +
                                        "Circulating supply: ${coinDataitem.circulating_supply}\n" +
                                        "\n" +
                                        "Market capitalization: ${coinDataitem.market_cap}",
                                color = KingBlue,
                                modifier = Modifier
                                    .padding(padding),
                                fontSize = Typography.body1.fontSize,
                                fontFamily = Typography.body1.fontFamily
                            )
                        }
                        Image(
                            painter = rememberAsyncImagePainter(coinDataitem.image),
                            contentDescription = "image",
                            modifier = Modifier
                                .size(imageSize)
                                .padding(imagePadding)
                        )

                    }

                }
            }
        }
    }
}