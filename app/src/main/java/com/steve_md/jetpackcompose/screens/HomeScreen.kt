package com.steve_md.jetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steve_md.jetpackcompose.R
import com.steve_md.jetpackcompose.data.SendMoneyItem
import com.steve_md.jetpackcompose.ui.theme.*


@Composable
fun HomeScreen() {
    val sendMoneyData= mutableListOf (
        SendMoneyItem(R.drawable.user1,"Jimmy","$55.90"),
        SendMoneyItem(R.drawable.user2,"Kate","$156.54"),
        SendMoneyItem(R.drawable.user3,"Smith","$840.36"),
        SendMoneyItem(R.drawable.user3,"John","$840.36")
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderUI()
        CardUI()
        DataUI()
        ServicesUI()
        SendMoneyUI(sendMoneyData)
    }
}

@Composable
fun SendMoneyUI(sendMoneyData: MutableList<SendMoneyItem>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Send Money",
            color = Color.LightGray,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        LazyRow {
            items(sendMoneyData ) {item->
                SendMoneyItemUI(item)
            }
        }
    }
}

@Composable
fun SendMoneyItemUI(item: SendMoneyItem) {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .padding(end = 6.dp)
            .border(width = 0.dp, color = Color.LightGray, shape = Shapes.medium)
            .padding(vertical = 10.dp)

    ) {
        Column(
            modifier = Modifier.size(width = 100.dp, height = Dp.Unspecified),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = item.name,
                color = Color.LightGray,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif
            )
            Text(
                text = item.Amount,
                color = Color.LightGray,
                modifier = Modifier.alpha(0.8f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Composable
fun ServicesUI() {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(
            text = "Services",
            color = Color.LightGray,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            ServiceUI(R.drawable.ic_money_send, "Send", Service1)
            ServiceUI(R.drawable.ic_bill, "Bill", Service2)
            ServiceUI(R.drawable.ic_recharge, "Recharge", Service3)
            ServiceUI(R.drawable.ic_more, "More", Service4)
        }

    }

}

@Composable
fun ServiceUI(id: Int, text: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier.size(60.dp),  //avoid the oval shape
            shape = CircleShape,
            //border= BorderStroke(0.dp, color),
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.outlinedButtonColors(contentColor = color)
        ) {
            Icon(painter = painterResource(id = id), contentDescription = "content description")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = text,
            color = Color.LightGray,
            modifier = Modifier.alpha(0.6f),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif
        )
    }
}

@Composable
fun DataUI() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 30.dp), Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "$87.50K",
                color = Color.LightGray,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                lineHeight = 20.sp
            )
            Text(
                text = "Total Income",
                color = Color.LightGray,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
        Column {
            Text(
                text = "$12.80K",
                color = Color.LightGray,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                lineHeight = 20.sp
            )
            Text(
                text = "Total Spent",
                color = Color.LightGray,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CardUI() {
    Card(
        backgroundColor = purple,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(160.dp),
    ) {
        Row {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.6f)
                        .padding(top = 10.dp),
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = "$28,067.50",
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    fontSize = 30.sp
                )
                Button(
                    onClick = { },
                    modifier = Modifier
                        .clip(Shapes.large)
                        .border(width = 0.dp, color = Color.Transparent, shape = Shapes.large),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                ) {
                    Text(
                        text = "Withdraw",
                        fontSize = 12.sp,
                        modifier = Modifier.align(alignment = CenterVertically)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .alpha(0.4f)
                    .size(80.dp)
                    .padding(top = 20.dp, start = 20.dp)
            )
        }

    }
}

@Composable
fun HeaderUI() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 16.dp)
            .fillMaxWidth(),
        Arrangement.spacedBy(20.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "profile_image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .border(width = 0.dp, Color.Transparent, shape = Shapes.large)
                .clip(Shapes.medium)
        )
        Column {
            Text(
                text = "Hi Stephen,",
                modifier = Modifier.alpha(0.8f),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            )
            Text(
                text = "Welcome Back",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                fontWeight = FontWeight.Normal,
                color = Color.LightGray
            )
        }
        //Spacer(modifier = Modifier.fillMaxWidth())

    }
}