package com.practice.trace.feature_trace.presentation.expense_money

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.presentation.expense_money.components.ExpenseMoneyItem

@Composable
fun ExpenseMoneyScreen(
    navController: NavController,
    viewModel: ExpenseMoneyViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.expenseMoney) { money ->
                ExpenseMoneyItem(money = money)
            }
        }
    }
}