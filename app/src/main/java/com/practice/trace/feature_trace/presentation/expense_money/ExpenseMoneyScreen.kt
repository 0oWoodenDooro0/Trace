package com.practice.trace.feature_trace.presentation.expense_money

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.CalendarView
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.practice.trace.R
import com.practice.trace.feature_trace.presentation.expense_money.components.ExpenseMoneyItem
import com.practice.trace.ui.theme.ExpenseBackground
import com.practice.trace.ui.theme.ExpenseText
import com.practice.trace.ui.theme.Primary
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("UnrememberedMutableState")
@ExperimentalMaterialApi
@Composable
fun ExpenseMoneyScreen(
    navController: NavController,
    viewModel: ExpenseMoneyViewModel = hiltViewModel()
) {
    val state = mutableStateOf(viewModel.state.value)
    val datePickerState = mutableStateOf(false)

    val calendar = viewModel.date.value
    val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.TAIWAN)
    val total = viewModel.total.value

    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = mutableStateOf(dateFormat.format(calendar.time))
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        R.style.DatePickerDialog
    )
    datePickerDialog.setOnDateSetListener { _, _year, _month, _dayOfMonth ->
        calendar.set(_year, _month, _dayOfMonth)
        date.value = dateFormat.format(calendar.time)
    }

    if (datePickerState.value) {
        AndroidView(
            factory = { context ->
                CalendarView(context)
            },
            modifier = Modifier.wrapContentWidth(),
            update = { view ->
                view.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    datePickerState.value = false
                    calendar.set(year, month, dayOfMonth)
                    date.value = dateFormat.format(calendar.time)
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ExpenseBackground)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = date.value
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
            items(state.value.expenseMoney) { money ->
                ExpenseMoneyItem(money = money)
            }
        }
    }

}