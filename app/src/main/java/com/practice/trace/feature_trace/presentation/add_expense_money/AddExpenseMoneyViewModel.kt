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

    private val _state = mutableStateOf(AddExpenseMoneyState())
    val state: State<AddExpenseMoneyState> = _state

    private var currentMoneyId: Int? = null

    init {
        savedStateHandle.get<Int>("moneyId")?.let { moneyId ->
            if (moneyId != -1) {
                viewModelScope.launch {
                    moneyUseCases.getMoney(moneyId)?.also { money ->
                        currentMoneyId = money.id
                        _state.value = state.value.copy(
                            amount = money.amount,
                            isSoftKeyBoardVisible = false,
                            category = money.category,
                            description = money.description,
                            account = money.account
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddExpenseMoneyEvent) {
        when (event) {
            is AddExpenseMoneyEvent.SaveMoney -> {
                viewModelScope.launch {
                    try {
                        moneyUseCases.addMoney(
                            Money(
                                id = currentMoneyId,
                                amount = state.value.amount,
                                description = state.value.description,
                                category = state.value.category,
                                account = state.value.account,
                                timestamp = System.currentTimeMillis(),
                                type = "Expense"
                            )
                        )
                    } catch (e: Exception) {
                        print("Failed")
                    }
                }
            }
            is AddExpenseMoneyEvent.Amount -> {
                _state.value = state.value.copy(
                    amount = event.value
                )
            }
            is AddExpenseMoneyEvent.AmountFocused -> {
                _state.value = state.value.copy(
                    isSoftKeyBoardVisible = true
                )
            }
            is AddExpenseMoneyEvent.Category -> {
                _state.value = state.value.copy(
                    category = event.value
                )
            }
            is AddExpenseMoneyEvent.Description -> {
                _state.value = state.value.copy(
                    description = event.value
                )
            }
            is AddExpenseMoneyEvent.Account -> {
                _state.value = state.value.copy(
                    account = event.value
                )
            }
        }
    }
}