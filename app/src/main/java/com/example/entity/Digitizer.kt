package com.example.entity

open class Digitizer<out T : Subject> {
    open fun convert(item: @UnsafeVariance T): Disk {
        return when (item) {
            is DigitizableSub -> item.createDigitizableSub()
            else -> throw IllegalArgumentException("Диск нельзя оцифровать")
        }
    }
}