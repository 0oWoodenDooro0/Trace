package com.practice.trace.feature_trace.presentation.expense_money.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.practice.trace.ui.theme.Primary
import com.practice.trace.ui.theme.white

@Preview
@Composable
fun ExpenseMoneyAppBar() {
    TopAppBar(title = { Text(text = "2021/11/25") },navigationIcon={IconButton(onClick ={}){Icon(Icons.Filled.Menu,"")} }, backgroundColor = Primary, contentColor = white, actions = {})
}