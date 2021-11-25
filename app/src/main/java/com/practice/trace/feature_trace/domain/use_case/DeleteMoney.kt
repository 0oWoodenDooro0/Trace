package com.practice.trace.feature_trace.domain.use_case

import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.domain.repository.MoneyRepository

class DeleteMoney(
    private val repository: MoneyRepository
) {

    suspend operator fun invoke(money: Money){
        repository.deleteMoney(money)
    }
}