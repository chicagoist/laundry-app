package com.github.chicagoist.laundryapp.app

import com.github.chicagoist.laundryapp.util.formatTime

fun main() {
    println("Введите данные о машинке:")

    print("Машина (Washer или Dryer): ")
    val machine = readln()

    println("Выберите состояние:")
    println("1 - working")
    println("2 - broken")
    println("3 - maintenance")

    val status = when (readln().toIntOrNull()) {
        1 -> "working"
        2 -> "broken"
        3 -> "maintenance"
        else -> {
            println("Ошибка: неверный ввод статуса! Программа завершена.")
            return
        }
    }

    print("Время работы в минутах: ")
    val worktime = readln().toIntOrNull() ?: 0

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