package com.practice.trace.feature_trace.presentation.add_expense_money

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.domain.use_case.MoneyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExpenseMoneyViewModel @Inject constructor(
    private val moneyUseCases: MoneyUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _amount = mutableStateOf(AddExpenseMoneyState().amount)
    val amount: State<Int> = _amount

    private val _category = mutableStateOf(AddExpenseMoneyState().category)
    val category: State<String> = _category

    private val _description = mutableStateOf(AddExpenseMoneyState().description)
    val description: State<String> = _description

    private val _account = mutableStateOf(AddExpenseMoneyState().account)
    val account: State<String> = _account

    private var currentMoneyId: Int? = null

    init{
        savedStateHandle.get<Int>("moneyId")?.let { moneyId ->
            if (moneyId != -1){
                viewModelScope.launch{
                    moneyUseCases.getMoney(moneyId)?.also{ money->
                        currentMoneyId = money.id
                        _amount.value = money.amount
                        _category.value = money.category
                        _description.value = money.description
                        _account.value = money.account
                    }
                }
            }
        }
    }

    fun onEvent(event: AddExpenseMoneyEvent) {
        when (event) {
            is AddExpenseMoneyEvent.SaveMoney -> {
                viewModelScope.launch {
                    moneyUseCases.addMoney(
                        Money(
                            id = currentMoneyId,
                            amount = amount.value,
                            description = description.value,
                            category = category.value,
                            account = account.value,
                            timestamp = System.currentTimeMillis(),
                            type = "Expense"
                        )
                    )
                }
            }
            is AddExpenseMoneyEvent.Amount -> {
                _amount.value = amount.value
            }
            is AddExpenseMoneyEvent.AmountFocused -> {
                _amount.value = amount.value
            }
            is AddExpenseMoneyEvent.Category -> {
                _category.value = category.value
            }
            is AddExpenseMoneyEvent.Description -> {
                _description.value = description.value
            }
            is AddExpenseMoneyEvent.Account -> {
                _account.value = account.value
            }
        }
    }
}