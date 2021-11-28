package com.practice.trace.feature_trace.presentation

sealed class Screen(val route: String){
    object ExpenseMoneyScreen: Screen(route = "expense_money_screen")
    object AddExpenseMoneyScreen: Screen(route = "add_expense_money_screen")
    object ExpenseMoneyDetailScreen: Screen(route = "expense_money_detail_screen")
    object IncomeMoneyScreen: Screen(route = "income_money_screen")
    object AddIncomeMoneyScreen: Screen(route = "add_income_money_screen")
    object IncomeMoneyDetailScreen: Screen(route = "income_money_detail_screen")
}
