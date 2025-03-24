package com.example.entity

class Newspaper(
    id: Int, accessibility: Boolean, name: String, val issueNumber: Int, val issueMonth: Month
) : Subject(id, accessibility, name), InLibraryUse {

    override fun getTypeName(): String = "Газета"
    override fun readInHallAction() {
        accessibility = false
    }

    override fun printDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name за ${issueMonth.rusName} с id: $id доступен: ${if (accessibility) "Да" else "Нет"}"
    }

    override fun createDigitizableSub(): Disk {
        return Disk(this.id,true,"Оцифрованная газета: ${this.name} (${this.issueMonth.rusName})", "CD")
    }
}