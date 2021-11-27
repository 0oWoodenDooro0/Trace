package com.practice.trace.feature_trace.presentation.expense_money

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.presentation.expense_money.components.ExpenseMoneyItem
import com.practice.trace.ui.theme.ExpenseBackground
import com.practice.trace.ui.theme.ExpenseText
import com.practice.trace.ui.theme.Primary
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ExpenseMoneyScreen(
    context: Context,
    viewModel: ExpenseMoneyViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    val calendar = viewModel.date.value
    val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.TAIWAN)

    val total = viewModel.total.value

    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            date.value = "$day/$month/$year"
        },
        year,
        month,
        day
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ExpenseBackground)
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
            contentColor = ExpenseText,
            actions = {
                IconButton(onClick = {
                    datePickerDialog.show()
                }) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = ""
                    )
                }
                IconButton(onClick = {
                    /*TODO Navigate AddExpenseMoney*/
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
                .fillMaxWidth()
                .padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TWD",
                color = ExpenseText,
                fontSize = 50.sp
            )
            Text(
                text = total.toString(),
                color = ExpenseText,
                fontSize = 50.sp
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            items(state.expenseMoney) { money ->
                ExpenseMoneyItem(money = money)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalMaterialApi
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun Screen() {

    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.TAIWAN)

    val moneyList = arrayListOf(
        Money(
            id = 1,
            amount = 345,
            description = "",
            category = "Lunch",
            account = "cash",
            timestamp = 0L,
            type = "expense"
        ),
        Money(
            id = 2,
            amount = 259,
            description = "",
            category = "Clothing",
            account = "cash",
            timestamp = 0L,
            type = "expense"
        ),
        Money(
            id = 3,
            amount = 789,
            description = "",
            category = "34",
            account = "cash",
            timestamp = 0L,
            type = "expense"
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ExpenseBackground)
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
            contentColor = ExpenseText,
            actions = {
                IconButton(onClick = {
                    /*TODO DatePicker*/
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
                .fillMaxWidth()
                .padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TWD",
                color = ExpenseText,
                fontSize = 50.sp
            )
            Text(
                text = "256",
                color = ExpenseText,
                fontSize = 50.sp
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            items(moneyList) { money ->
                ExpenseMoneyItem(money = money)
            }
        }
    }
}