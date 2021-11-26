package com.practice.trace.feature_trace.domain.use_case

import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.domain.repository.MoneyRepository

class GetMoney(
    private val repository: MoneyRepository
) {

    suspend operator fun invoke(id: Int): Money? {
        return repository.getMoneyById(id)
    }
}