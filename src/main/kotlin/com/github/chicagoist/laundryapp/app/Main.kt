package com.github.chicagoist.laundryapp.app

import com.github.chicagoist.laundryapp.util.formatTime

fun main() {
    println("Введите данные о машинке:")

    print("Машина (Washer или Dryer): ")
    val machine = readln()
    if (machine != "Washer" && machine != "Dryer") {
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
    }
    val status = "working" // Присваиваем единственное допустимое значение


    print("Время работы в минутах: ")
    val worktime = readln().toIntOrNull() ?: 0
    if (worktime <= 0) {
        println("Ошибка: время должно быть положительным числом!")
        return
    } else if (worktime > 180) {
        println("Предупреждение: время работы превышает 3 часа")
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