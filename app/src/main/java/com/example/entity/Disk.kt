package com.example.entity

data class Disk(
    override val id: Int, override var accessibility: Boolean, override var name: String, val diskType: String
) : Subject(id, accessibility, name), HomeLendable {
    override fun getTypeName(): String = "Диск"
    override fun takeHomeAction() {
        accessibility = false
    }

    override fun printDetailedInfo(): String {
        return "$diskType $name доступен: ${if (accessibility) "Да" else "Нет"}"
    }
}