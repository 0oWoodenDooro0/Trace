package com.practice.trace.feature_trace.presentation.add_expense_money

import androidx.compose.ui.focus.FocusState
import com.practice.trace.feature_trace.domain.model.Money

sealed class AddExpenseMoneyEvent {
    object SaveMoney : AddExpenseMoneyEvent()
    data class Amount(val value: Int): AddExpenseMoneyEvent()
    object AmountFocused: AddExpenseMoneyEvent()
    data class Category(val value: String): AddExpenseMoneyEvent()
    data class Description(val value: String): AddExpenseMoneyEvent()
    data class Account(val value: String): AddExpenseMoneyEvent()
}