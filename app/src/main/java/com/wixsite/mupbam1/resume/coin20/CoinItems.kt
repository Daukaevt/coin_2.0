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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.wixsite.mupbam1.resume.coin20.R
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem
import java.text.DecimalFormat



@Composable
fun ItemColumn(coinDataitem: coin_dataItem) {
    val colorSalad= colorResource(id = R.color.salad)
    val colorYellow= colorResource(id = R.color.yellow)
       var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { isExpanded=!isExpanded }
        .padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
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
                        .size(64.dp)
                        .padding(3.dp)
                )
                Column(modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = coinDataitem.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif)

                    Text(text = coinDataitem.current_price.toString(),
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                       // fontWeight = FontWeight.Bold
                    )

                }
                Column(modifier = Modifier.padding(8.dp)) {
                    val price_change_percentage=coinDataitem.price_change_percentage_24h
                    val formattedDouble: String = DecimalFormat("#0.00").format(price_change_percentage)
                    Text(text = formattedDouble+"%",
                        textAlign = TextAlign.Right,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif)
                }
            }
        }
    }
    if (isExpanded) {
        Text(text = "sfjvb;waervnqklejrnvqlknrv" +
                "arkjgbfakjrfvakjf" +
                "a.dkjvbqrekjvh;qkJHVN" +
                "FVNA;KJRVNA;KJLGN" )
    }
}