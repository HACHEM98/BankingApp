package com.example.bankingapp

import android.graphics.Paint.Style
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.Finance
import com.example.bankingapp.ui.theme.blueStart
import com.example.bankingapp.ui.theme.greenStart
import com.example.bankingapp.ui.theme.orangeStart
import com.example.bankingapp.ui.theme.purpleStart

val financeList = listOf<Finance>(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = orangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = blueStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = purpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = greenStart
    )



)
@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(text = "Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(financeList.size) {
                FinanceItem(it)
            }
        }
    }
}
@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]
    val horizantalePadding = 0.dp
    val startPadding = if (index == 0) 16.dp else  horizantalePadding
    val enPadding = if(index == financeList.size - 1) 16.dp else horizantalePadding
Box(modifier = Modifier.padding(start = 16.dp,end = enPadding))
{
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable { }
            .padding(16.dp)
            .size(120.dp),
        verticalArrangement = Arrangement.SpaceBetween
          ) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(finance.background)
                .padding(6.dp)

        ) {
            androidx.compose.material3.Icon(
                imageVector = finance.icon,
                contentDescription = finance.name,
                tint = White
            )
        }

        Text(
            text = finance.name,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )


    }
            }
}
