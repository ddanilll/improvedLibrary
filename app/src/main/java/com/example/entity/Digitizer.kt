package com.example.entity

open class Digitizer<T : Subject> {
    open fun convert(item: T): Disk {
        return when (item) {
            is DigitizableSub -> item.createDigitizableSub()
            else -> throw IllegalArgumentException("Диск нельзя оцифровать")
        }
    }
}