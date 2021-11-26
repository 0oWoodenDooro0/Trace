package com.practice.trace.feature_trace.domain.use_case

data class MoneyUseCases(
    val getMoneyList: GetMoneyList,
    val deleteMoney: DeleteMoney,
    val addMoney: AddMoney,
    val getMoney: GetMoney
)
