package com.example.improvedlibrary

import com.example.entity.Book
import com.example.entity.BookShop
import com.example.entity.Digitizer
import com.example.entity.Disk
import com.example.entity.DiskShop
import com.example.entity.HomeLendable
import com.example.entity.InLibraryUse
import com.example.entity.Manager
import com.example.entity.Month
import com.example.entity.Newspaper
import com.example.entity.NewspaperShop
import com.example.entity.Subject

fun main() {
    val librarySubject = listOf(
        Book(1, true, "Маугли", 100, "Джозеф Киплинг"),
        Book(2, true, "Бесы", 1000, "Федор Достоевский"),
        Book(3, true, "Три товарища", 450, "Эрих Мария Ремарк"),
        Newspaper(4, true, "Правда", 794, Month.May),
        Newspaper(5, true, "Тайны вселенной", 123, Month.July),
        Newspaper(6, true, "Новости", 456, Month.February),
        Disk(7, true, "Веном", "DVD"),
        Disk(8, true, "Форсаж", "CD"),
        Disk(9, true, "Марвел", "DVD")
    )

    while (true) {
        println(
            "1.Показать книги\n" + "2.Показать газеты\n" + "3.Показать диски\n" + "4.Управление менеджером\n"
        )
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                println("Cписок книг:")
                showItems(filterByType<Book>(librarySubject))
            }

            2 -> {
                println("Cписок газет:")
                showItems(filterByType<Newspaper>(librarySubject))
            }

            3 -> {
                println("Cписок дисков:")
                showItems(filterByType<Disk>(librarySubject))
            }

            4 -> buying()

            else -> println("Неправильный выбор. Пожалуйста, выберите снова.")
        }
    }
}

fun buying() {
    val manager = Manager()
    println("Выберите тип магазина: 1-книги, 2-газеты, 3-диски")
    val shop = when (readlnOrNull()?.toIntOrNull()) {
        1 -> BookShop
        2 -> NewspaperShop
        3 -> DiskShop
        else -> null
    }
    shop?.let {
        val item = manager.buy(it)
        println("Куплен: ${item.getTypeName()}")
    }
}

inline fun <reified T> filterByType(items: List<Subject>): List<T> {
    return items.filterIsInstance<T>()
}

fun showItems(items: List<Subject>) {
    items.forEachIndexed { index, item ->
        println("${index + 1}. ${item.printShortInfo()}")
    }

    println("Выберите объект:")
    val choice = readlnOrNull()?.toIntOrNull()
    if (choice != null && choice in 1..items.size) {
        val selectedItem = items[choice - 1]
        showActions(selectedItem)
    } else {
        println("Неправильный выбор. Пожалуйста, выберите снова.")
    }
}

fun showActions(item: Subject) {
    while (true) {
        println("Меню действий:")
        println(
            "1. Взять домой\n" + "2. Читать в читальном зале\n" + "3. Показать подробную информацию\n" + "4. Вернуть\n" + "5. Оцифровать\n" + "6. Назад\n"
        )
        val digitizer = Digitizer<Subject>()
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> takeHome(item)
            2 -> readInHall(item)
            3 -> println(item.printDetailedInfo())
            4 -> returnItem(item)
            5 -> digitizer.convert(item)
            6 -> return
            else -> println("Неправильный выбор. Пожалуйста, выберите снова.")
        }
    }
}

fun takeHome(item: Subject) {
    when {
        !item.accessibility -> println("Объект недоступен")
        item is HomeLendable -> {
            item.takeHomeAction()
            println("${item.getTypeName()} с id ${item.id} взят домой")
        }

        else -> println("Нельзя взять домой")
    }
}

fun readInHall(item: Subject) {
    when {
        !item.accessibility -> println("Объект недоступен")
        item is InLibraryUse -> {
            item.readInHallAction()
            println("${item.getTypeName()} с id ${item.id} взят в читальный зал")
        }

        else -> println("Нельзя читать в зале")
    }
}

fun returnItem(item: Subject) {
    if (!item.accessibility) {
        item.accessibility = true
        println("Объект ${item.getTypeName()} с id ${item.id} возвращен.")
    } else {
        println("Объект уже доступен.")
    }
}