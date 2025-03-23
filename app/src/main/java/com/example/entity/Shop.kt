package com.example.entity

sealed interface Shop<T: Subject> {
    fun sell(): T
}