package com.practice.trace.feature_trace.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practice.trace.feature_trace.domain.model.Money

@Database(
    entities = [Money::class],
    version = 1
)
abstract class MoneyDatabase : RoomDatabase() {

    abstract val moneyDao: MoneyDao

    companion object{
        const val DATABASE_NAME = "money_db"
    }
}