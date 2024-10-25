package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.Card
import com.example.bankingapp.ui.theme.blueEnd
import com.example.bankingapp.ui.theme.blueStart
import com.example.bankingapp.ui.theme.greenEnd
import com.example.bankingapp.ui.theme.greenStart
import com.example.bankingapp.ui.theme.orangeEnd
import com.example.bankingapp.ui.theme.orangeStart
import com.example.bankingapp.ui.theme.purpleEnd
import com.example.bankingapp.ui.theme.purpleStart

val cards = listOf<Card>(
    Card(
        cardType = "VISA",
        cardName = "Business",
        cardNumber = "3654 7896 4562 1459",
        Balance = 58.63,
        color = getGradient(purpleStart, purpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardName = "Savings",
        cardNumber = "4789 5123 2456 8963",
        Balance = 23.54,
        color = getGradient(blueStart, blueEnd)
    ),
    Card(
        cardType = "VISA",
        cardName = "School",
        cardNumber = "5236 5123 5896 8963",
        Balance = 3.54,
        color = getGradient(orangeStart, orangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardName = "Trips",
        cardNumber = "3214 5123 2456 8754",
        Balance = 998.54,
        color = getGradient(greenStart, greenEnd)
    ),
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index -> CardItem(index) }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    val horizontalPadding = 8.dp // Padding between items
    val startPadding = if (index == 0) 16.dp else horizontalPadding
    val endPadding = if (index == cards.size - 1) 16.dp else horizontalPadding

    val image = if (card.cardType == "MASTER CARD") {
        painterResource(id = R.drawable.ic_mastercard)
    } else {
        painterResource(id = R.drawable.ic_visa)
    }

    Box(
        modifier = Modifier.padding(start = startPadding, end = endPadding)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .width(250.dp)
                .height(160.dp)
                .background(card.color)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.Balance}",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
