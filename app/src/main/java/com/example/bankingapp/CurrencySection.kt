package com.example.bankingapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyBitcoin
import androidx.compose.material.icons.rounded.CurrencyFranc
import androidx.compose.material.icons.rounded.CurrencyLira
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.Currency
import com.example.bankingapp.ui.theme.greenStart

val currencies = listOf<Currency>(
    Currency(
        name = "USD",
        buy = 25.23f,
        sell = 26.24f,
        icon = Icons.Rounded.AttachMoney

    ),
    Currency(
        name = "EURO",
        buy = 29.36f,
        sell = 23.21f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 19.31f,
        sell = 123.21f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "LIRA",
        buy = 258.36f,
        sell = 36.21f,
        icon = Icons.Rounded.CurrencyLira
    ),
    Currency(
        name = "BITCOIN",
        buy = 369.36f,
        sell = 223.21f,
        icon = Icons.Rounded.CurrencyBitcoin
    ),
    Currency(
        name = "FRANC",
        buy = 269.36f,
        sell = 223.21f,
        icon = Icons.Rounded.CurrencyFranc
    )
)

@Preview
@Composable
fun CurrencySection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var icon by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
    Box(modifier = Modifier.fillMaxSize().padding(top = 32.dp), contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()

        ) {

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        icon = if (isVisible) {
                            Icons.Rounded.KeyboardArrowUp
                        } else {
                            Icons.Rounded.KeyboardArrowDown
                        }
                    }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "currencies",
                        modifier = Modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )

                }
                Spacer(modifier = Modifier.width(25.dp))
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )

            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                ) {
                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Currency",
                                modifier = Modifier.width(16.dp),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "Buy",
                                modifier = Modifier.width(16.dp),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                            Text(
                                text = "Sell",
                                modifier = Modifier.width(16.dp),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyRow {
                            items(currencies.size) { index ->
                                CurrencyItem(index = index, width = width)
                            }
                        }
                    }
                }

            }

        }
    }
}
@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val currency = currencies[index]
    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.width(width), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .padding(4.dp)
                    .background(greenStart)
            ) {
                Icon(
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    modifier = Modifier.size(18.dp),
                    tint = Color.White
                )
            }
            Text(
                text = currency.name,
                modifier = Modifier.width(16.dp).padding(start = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End
            )
        }
        Text(
            text = "$ ${currency.buy}",
            modifier = Modifier.width(16.dp).padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
        Text(
            text = "$ ${currency.sell}",
            modifier = Modifier.width(16.dp).padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

    }
}

