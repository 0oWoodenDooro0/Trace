package com.practice.trace.feature_trace.presentation.expense_money.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.ui.theme.white

@Composable
fun ExpenseMoneyItem(
    money: Money
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Red)
            .padding(5.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopStart),
            text = money.category,
            color = white,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd),
            text = "NT$${money.amount}",
            color = white,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(3.dp))
    }
}

@Preview(widthDp = 393, heightDp = 851)
@Composable
fun Preview() {
    ExpenseMoneyItem(
        money = Money(
            amount = 123,
            description = "",
            category = "Money",
            accounts = "cash",
            timestamp = 0L,
            type = "expense"
        )
    )
}