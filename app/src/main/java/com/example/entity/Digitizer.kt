package com.example.entity

class Digitizer<in T : Subject> {
    fun convert(item: T) {
        when (item) {
            is Book -> println("Оцифрованная книга: ${item.name}")
            is Newspaper -> println("Оцифрованная газета: ${item.name} (${item.issueMonth.rusName})")
            else -> println("Неподдерживаемый тип")
        }
    }
}