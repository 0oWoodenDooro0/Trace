package com.practice.trace.feature_trace.presentation.expense_money

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.trace.feature_trace.domain.use_case.MoneyUseCases
import com.practice.trace.feature_trace.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ExpenseMoneyViewModel @Inject constructor(
    private val moneyUseCases: MoneyUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ExpenseMoneyState())
    val state: State<ExpenseMoneyState> = _state

    private val _date = mutableStateOf(Calendar.getInstance())
    val date: State<Calendar> = _date

    private var getMoneyJob: Job?= null

    private val _total = mutableStateOf(0)
    val total: State<Int> = _total

    init {
        getMoney()
    }

    fun onEvent(event: ExpenseMoneyEvent) {
        when (event) {
            is ExpenseMoneyEvent.SwitchDate -> {
                _state.value = state.value.copy(
                    date = true
                )
            }
        }
    }

    private fun getMoney() {
        getMoneyJob?.cancel()
        getMoneyJob = moneyUseCases.getMoneyList(OrderType.Expense)
            .onEach { money ->
                _state.value = state.value.copy(
                    expenseMoney = money
                )
            }
            .launchIn(viewModelScope)
    }

}