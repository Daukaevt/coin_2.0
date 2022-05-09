package com.wixsite.mupbam1.resume.coin20.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.wixsite.mupbam1.resume.coin20.R
import com.wixsite.mupbam1.resume.coin20.data.coin_dataItem



@Composable
fun ItemColumn(coinDataitem: coin_dataItem) {
       var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.salad))) {
            Row(
            verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(coinDataitem.image),
                    contentDescription = "image",
                    modifier = Modifier.size(64.dp)
                        .padding(3.dp)
                )
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = coinDataitem.name,
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Serif)

                    Text(text = coinDataitem.current_price.toString(),
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold)

                }
            }
        }

    }
//    Row(
//        modifier = Modifier
//            .padding(8.dp)
//            .background(color = Color.White)
//    ) {
//                    Text(text = coinDataitem.image)
//    }
}