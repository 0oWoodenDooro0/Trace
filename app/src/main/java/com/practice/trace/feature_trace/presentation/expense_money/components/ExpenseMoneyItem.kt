package com.practice.trace.feature_trace.presentation.expense_money.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.ui.theme.*

@Composable
fun ExpenseMoneyItem(
    money: Money
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(ExpenseMoney)
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = money.category,
            color = White,
            fontSize = 20.sp
        )
        Text(
            text = "NT$${money.amount}",
            color = White,
            fontSize = 20.sp
        )
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
            account = "cash",
            timestamp = 0L,
            type = "expense"
        )
    )
}