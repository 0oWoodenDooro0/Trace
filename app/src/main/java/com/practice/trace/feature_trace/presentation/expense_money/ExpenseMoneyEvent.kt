package com.practice.trace.feature_trace.presentation.expense_money

sealed class ExpenseMoneyEvent{
    object AddExpenseMoney: ExpenseMoneyEvent()
    object SwitchDate:ExpenseMoneyEvent()
    object SelectExpenseMoney: ExpenseMoneyEvent()
}