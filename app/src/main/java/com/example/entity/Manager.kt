package com.example.entity

class Manager(private val shop: Shop<Subject>){
    fun buy(): Subject = shop.sell()
}