package com.example.entity

data object NewspaperShop : Shop<Newspaper>{
    override fun sell(): Newspaper {
        return Newspaper(4, true, "Правда", 794, Month.May)
    }
}