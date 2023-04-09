package com.steve_md.jetpackcompose.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
        SendMoneyItem(R.drawable.user1,"Jackline","Kes 200"),
        SendMoneyItem(R.drawable.user2,"Mirriam","Kes 500"),
        SendMoneyItem(R.drawable.user3,"Stephen","Kes 300"),
        SendMoneyItem(R.drawable.user3,"Victor","Kes 1000")
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
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        LazyRow {
            items(sendMoneyData) {item->
                SendMoneyItemUI(item)
            }
        }
    }
}

@Composable
fun SendMoneyItemUI(item: SendMoneyItem) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .padding(end = 6.dp)
            .border(width = 1.dp, color = Color.LightGray ,shape = Shapes.medium)
            .padding(vertical = 10.dp)

    ) {
        Column(
            modifier = Modifier.size(width = 100.dp, height = Dp.Unspecified),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "image",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = item.name,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold))
            )
            Text(
                text = item.Amount,
                modifier = Modifier.alpha(0.8f),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold))
            )
        }
    }
}

@Composable
fun ServicesUI() {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(
            text = "Services",
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            ServiceUI(R.drawable.ic_money_send, "Send", Service1)
            ServiceUI(R.drawable.ic_bill, "Pay bills", Service2)
            ServiceUI(R.drawable.ic_recharge, "Deposit", Service3)
            ServiceUI(R.drawable.ic_more, "More", Service4)
        }

    }

}

@Composable
fun ServiceUI(id: Int, text: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier.size(60.dp),  //avoid the oval shape
            shape = CircleShape,
            //border= BorderStroke(0.dp, color),
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.outlinedButtonColors(contentColor = color)
        ) {
            Icon(painter = painterResource(id = id), contentDescription = "services_icon")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = text,
            modifier = Modifier.alpha(0.6f),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
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
                text = "Kes 80,000",
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                lineHeight = 20.sp
            )
            Text(
                text = "Total Income",
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
        Column {
            Text(
                text = "Kes 12,000",
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                lineHeight = 20.sp
            )
            Text(
                text = "Total Spent",
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
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
        shape = RoundedCornerShape(10.dp)
    ) {
        Row {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.6f)
                        .padding(top = 10.dp),
                    fontFamily = FontFamily(Font(R.font.montserrat_semibold))
                )
                Text(
                    text = "Kes 98,000",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    fontSize = 30.sp
                )
                Button(
                    onClick = { },
                    modifier = Modifier
                        .clip(Shapes.large)
                        .border(width = 0.dp, color = Color.Transparent, shape = Shapes.large),
                    colors = ButtonDefaults.buttonColors(backgroundColor = pureGold),
                ) {
                    Text(
                        text = "Withdraw",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier.align(alignment = CenterVertically)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = "wallet_icon",
                tint = Color.White,
                modifier = Modifier
                    .alpha(0.8f)
                    .size(80.dp)
                    .padding(top = 36.dp, start = 16.dp)
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
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                fontWeight = FontWeight.Normal,
            )
        }
        //Spacer(modifier = Modifier.fillMaxWidth())

    }
}