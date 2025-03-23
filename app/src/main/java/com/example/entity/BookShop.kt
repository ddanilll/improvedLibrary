package com.example.entity

data object BookShop : Shop<Book> {
    override fun sell(): Book {
        return Book(1, true, "Маугли", 100, "Джозеф Киплинг")
    }
}