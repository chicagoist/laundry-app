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
    if (choice == null || choice !in 1..3) {
        println("Ошибка: введите цифру 1, 2 или 3!")
        return
    }

    val status = when (choice) {
        1 -> "working"
        2 -> "broken"
        3 -> "maintenance"
        else -> {
            println("Ошибка: неверный ввод статуса! Программа завершена.")
            return
        }
    }

    if (choice == 2 || choice == 3) {
        println("Ошибка: машина не может быть в этом состоянии!")
    }



    print("Время работы в минутах: ")
    val worktime = readln().toIntOrNull() ?: 0
    if (worktime <= 0) {
        println("Время должно быть > 0!")
        return
    } else if (worktime > 180) {
        println("Время превышает 3 часа")
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