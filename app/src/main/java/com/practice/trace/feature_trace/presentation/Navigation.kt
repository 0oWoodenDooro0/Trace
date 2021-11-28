package com.practice.trace.feature_trace.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.trace.feature_trace.domain.use_case.*
import com.practice.trace.feature_trace.presentation.expense_money.ExpenseMoneyScreen
import com.practice.trace.feature_trace.presentation.expense_money.ExpenseMoneyViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.ExpenseMoneyScreen.route
    ){
        composable(route = Screen.ExpenseMoneyScreen.route) {
            ExpenseMoneyScreen(
                navController = navController
            )
        }
        composable(route = Screen.ExpenseMoneyDetailScreen.route) {

        }
        composable(route = Screen.IncomeMoneyScreen.route) {

        }
        composable(route = Screen.AddIncomeMoneyScreen.route) {

        }
        composable(route = Screen.IncomeMoneyDetailScreen.route) {

        }
    }
}