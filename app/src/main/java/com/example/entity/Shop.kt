package com.example.entity

sealed interface Shop<out T: Subject> {
    fun sell(): T
}