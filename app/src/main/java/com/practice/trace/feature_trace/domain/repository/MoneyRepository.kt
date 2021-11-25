package com.practice.trace.feature_trace.domain.repository

import com.practice.trace.feature_trace.domain.model.Money
import kotlinx.coroutines.flow.Flow

interface MoneyRepository {

    fun getExpenseMoney(): Flow<List<Money>>

    fun getIncomeMoney(): Flow<List<Money>>

    suspend fun getMoneyById(id :Int): Money?

    suspend fun insertMoney(money :Money)

    suspend fun deleteMoney(money :Money)
}