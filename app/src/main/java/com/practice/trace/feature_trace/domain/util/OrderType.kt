package com.practice.trace.feature_trace.domain.util

sealed class OrderType{
    object Expense: OrderType()
    object Income: OrderType()
}
