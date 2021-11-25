package com.practice.trace.feature_trace.presentation.expense_money

import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.domain.util.OrderType

data class ExpenseMoneyState(
    val expenseMoney: List<Money> = emptyList()
)