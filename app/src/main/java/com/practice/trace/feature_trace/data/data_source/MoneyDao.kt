package com.practice.trace.feature_trace.data.data_source

import androidx.room.*
import com.practice.trace.feature_trace.domain.model.Money
import kotlinx.coroutines.flow.Flow

@Dao
interface MoneyDao {

    @Query("SELECT * FROM money WHERE type = 'expense'")
    fun getExpenseMoney(): Flow<List<Money>>

    @Query("SELECT * FROM money WHERE type = 'income'")
    fun getIncomeMoney(): Flow<List<Money>>

    @Query("SELECT * FROM money WHERE id = :id")
    suspend fun getMoneyById(id: Int): Money?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoney(money: Money)

    @Delete
    suspend fun deleteMoney(money: Money)
}