package com.example.entity

abstract class Subject(
    open val id: Int, open var accessibility: Boolean, open val name: String
) {
    open fun getTypeName(): String = "Неизвестный тип"

    open fun printShortInfo(): String {
        return "$name доступна: ${if (accessibility) "Да" else "Нет"}"
    }

    open fun printDetailedInfo(): String {
        return ""
    }
}