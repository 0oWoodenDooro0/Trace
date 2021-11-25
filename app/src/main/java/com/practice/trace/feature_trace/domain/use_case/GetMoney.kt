package com.practice.trace.feature_trace.domain.use_case

import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.domain.repository.MoneyRepository
import com.practice.trace.feature_trace.domain.util.OrderType
import kotlinx.coroutines.flow.Flow

class GetMoney(
    private val repository: MoneyRepository
) {

    operator fun invoke(
        orderType: OrderType = OrderType.Expense
    ): Flow<List<Money>> {
        return if (orderType == OrderType.Expense) repository.getExpenseMoney()
        else repository.getIncomeMoney()
    }
}