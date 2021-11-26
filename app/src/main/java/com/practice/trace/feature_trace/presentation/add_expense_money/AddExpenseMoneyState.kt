package com.practice.trace.feature_trace.presentation.add_expense_money

data class AddExpenseMoneyState(
    val amount: Int = 0,
    val isSoftKeyBoardVisible: Boolean = false,
    val category: String = "",
    val description: String = "",
    val account: String = ""
)