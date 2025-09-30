package com.github.chicagoist.laundryapp.app

import com.github.chicagoist.laundryapp.util.formatTime

fun main() {
    val status: String

    print("Введите данные о машинке. Машина (Washer или Dryer): ")
    val machine = readln().lowercase()

    if (machine != "washer" && machine != "dryer") {
        println("Неверное название машины")
        return
    }

    println("Выберите состояние:")
    println("1 - working")
    println("2 - broken")
    println("3 - maintenance")

    val choice = readln().toIntOrNull()
    // Secure-first: если ввод не число ИЛИ число не 1 -> ОШИБКА
    if (choice == null || choice != 1) {
        println("Ошибка: машина должна быть в состоянии 'working'!")
        return // Немедленное завершение
    } else {
        status = "working" // Присваиваем единственное допустимое значение
    }

    print("Время работы в минутах: ")
    val worktime = readln().toIntOrNull() ?: 0

    // SECURE-FIRST: сначала базовая валидация
    if (worktime <= 0) {
        println("Ошибка: время должно быть положительным числом!")
        return
    }

    // Проверка времени для разных типов машин
    if (machine == "dryer" && worktime > 120) {
        println("Предупреждение: время сушки превышает 2 часа")
    } else if (machine == "washer" && worktime > 180) {
        println("Предупреждение: время стирки превышает 3 часа")
    }

    println(
        """
        |--- Данные машины ---
        |Машина: $machine
        |Состояние: $status
        |Время работы: ${formatTime(worktime)}
        |---------------------
        """.trimMargin()
    )
}