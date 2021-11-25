package com.practice.trace.feature_trace.domain.use_case

import com.practice.trace.feature_trace.domain.model.InvalidMoneyException
import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.domain.repository.MoneyRepository

class AddMoney(
    private val repository: MoneyRepository
) {

    @Throws(InvalidMoneyException::class)
    suspend operator fun invoke(money: Money){
        if (money.category.isBlank()){
            throw InvalidMoneyException("Please type amount")
        }
        if (money.amount == 0){
            throw InvalidMoneyException("Please choose category")
        }
        repository.insertMoney(money)
    }
}