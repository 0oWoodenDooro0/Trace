package com.practice.trace.feature_trace.data.repository

import com.practice.trace.feature_trace.data.data_source.MoneyDao
import com.practice.trace.feature_trace.domain.model.Money
import com.practice.trace.feature_trace.domain.repository.MoneyRepository
import kotlinx.coroutines.flow.Flow

class MoneyRepositoryImpl(
    private val dao: MoneyDao
): MoneyRepository {
    override fun getExpenseMoney(): Flow<List<Money>> {
        return dao.getExpenseMoney()
    }

    override fun getIncomeMoney(): Flow<List<Money>> {
        return dao.getIncomeMoney()
    }

    override suspend fun getMoneyById(id: Int): Money? {
        return dao.getMoneyById(id)
    }

    override suspend fun insertMoney(money: Money) {
        dao.insertMoney(money)
    }

    override suspend fun deleteMoney(money: Money) {
        dao.deleteMoney(money)
    }
}