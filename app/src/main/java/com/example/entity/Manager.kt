package com.example.entity

class Manager {
    fun <T : Subject> buy(shop: Shop<T>): T = shop.sell()
}