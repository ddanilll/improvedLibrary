package com.example.entity

open class Digitizer<T : Subject>{
    open fun convert(item: T): Disk {
        return when (item) {
            is Book -> Disk(item.id, true, "Оцифрованная книга: ${item.name}", "CD")
            is Newspaper -> Disk(item.id, true, "Оцифрованная газета: ${item.name} (${item.issueMonth.rusName})", "CD")
            else -> throw IllegalArgumentException("Диск нельзя оцифровать")
        }
    }
}