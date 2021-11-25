package com.practice.trace.feature_trace.presentation.expense_money

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ControlPoint
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.practice.trace.feature_trace.presentation.expense_money.components.ExpenseMoneyItem
import com.practice.trace.ui.theme.Primary
import com.practice.trace.ui.theme.white
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ExpenseMoneyScreen(
    navController: NavController,
    viewModel: ExpenseMoneyViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    val calendar = viewModel.date.value
    val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.TAIWAN)

    val total = viewModel.total.value

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = dateFormat.format(calendar.time)
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        /*TODO NavigationDrawer*/
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = ""
                    )
                }
            },
            backgroundColor = Primary,
            contentColor = white,
            actions = {
                IconButton(onClick = {
                    /*TODO ChangeDate*/
                }) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = ""
                    )
                }
                IconButton(onClick = {
                    /*TODO AddExpenseMoney*/
                }) {
                    Icon(
                        imageVector = Icons.Filled.ControlPoint,
                        contentDescription = ""
                    )
                }
            }
        )
        Row(
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth()
                .padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TWD",
                color = white,
                fontSize = 50.sp
            )
            Text(
                text = total.toString(),
                color = white,
                fontSize = 50.sp
            )
        }
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
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun Screen() {

    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.TAIWAN)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = dateFormat.format(calendar.time)
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        /*TODO NavigationDrawer*/
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = ""
                    )
                }
            },
            backgroundColor = Primary,
            contentColor = white,
            actions = {
                IconButton(onClick = {
                    /*TODO ChangeDate*/
                }) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = ""
                    )
                }
                IconButton(onClick = {
                    /*TODO AddExpenseMoney*/
                }) {
                    Icon(
                        imageVector = Icons.Filled.ControlPoint,
                        contentDescription = ""
                    )
                }
            }
        )
        Row(
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth()
                .padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TWD",
                color = white,
                fontSize = 50.sp
            )
            Text(
                text = "245",
                color = white,
                fontSize = 50.sp
            )
        }
    }
}