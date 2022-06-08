package com.wixsite.mupbam1.resume.coin20.ui.theme


import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.wixsite.mupbam1.resume.coin20.Const.elevation
import com.wixsite.mupbam1.resume.coin20.Const.imagePadding
import com.wixsite.mupbam1.resume.coin20.Const.imageSize
import com.wixsite.mupbam1.resume.coin20.Const.padding
import com.wixsite.mupbam1.resume.coin20.R
import com.wixsite.mupbam1.resume.coin20.coinDataList
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import java.text.DecimalFormat



@Composable
fun ItemColumn(coinDataitem: coin_dataItem) {
    val colorSalad= colorResource(id = R.color.salad)
    val colorYellow= colorResource(id = R.color.yellow)
    val colorWhite= colorResource(id = R.color.white)
       var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { isExpanded=!isExpanded }
        .padding(padding),
        shape = Shapes.large,
        elevation = elevation

    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorSalad,
                        colorYellow
                    )
                )
            )
        ) {
            Row(modifier = Modifier.fillMaxSize(),
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
                Column(modifier = Modifier.padding(padding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = coinDataitem.name,
                        fontSize = Typography.body2.fontSize,
                        fontWeight = Typography.body2.fontWeight,
                        fontFamily = Typography.body2.fontFamily)

                    Text(text = coinDataitem.current_price.toString(),
                        fontSize = Typography.caption.fontSize,
                        fontStyle = Typography.caption.fontStyle,
                       // fontWeight = FontWeight.Bold
                    )

                }
                Column(modifier = Modifier.padding(padding)) {
                    val price_change_percentage=coinDataitem.price_change_percentage_24h
                    val formattedDouble: String = DecimalFormat("#0.00").format(price_change_percentage)
                    Text(text = formattedDouble+"%",
                        textAlign = TextAlign.Right,
                        fontSize = Typography.body2.fontSize,
                        fontFamily = Typography.body2.fontFamily)
                }
            }
        }
    }
    if (isExpanded) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .clip(Shapes.large)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorYellow,
                            colorWhite
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
                modifier = Modifier
                    .padding(padding),
                fontSize = Typography.body1.fontSize,
                fontFamily = Typography.body1.fontFamily

            )
        }
    }
}