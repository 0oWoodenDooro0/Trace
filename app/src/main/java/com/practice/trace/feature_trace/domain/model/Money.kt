package com.practice.trace.feature_trace.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Money(
    @PrimaryKey val id :Int? = null,
    val amount: Int,
    val description: String,
    val category: String,
    val account : String,
    val timestamp : Long,
    val type: String
)

class InvalidMoneyException(message:String) : Exception(message)