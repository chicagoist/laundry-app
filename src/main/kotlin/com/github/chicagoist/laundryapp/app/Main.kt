package com.github.chicagoist.laundryapp.app

import com.github.chicagoist.laundryapp.model.Machine
import com.github.chicagoist.laundryapp.model.MachineType
import com.github.chicagoist.laundryapp.model.User
import com.github.chicagoist.laundryapp.service.QueueManager
import com.github.chicagoist.laundryapp.util.formatTime


fun main() {
    println("Введите данные стиральной машины:")

    print("Название: ")
    val name = readln()

    print("ID: ")
    val id = readln().toIntOrNull() ?: 0

    print("Тип (например, Washer): ")
    val type = readln()

    print("Статус (например, Свободна): ")
    val status = readln()

    print("Время стирки в минутах: ")
    val worktime = readln().toIntOrNull() ?: 30

    // Используем многострочную строку и шаблоны для вывода
    println(
        """
        |--- Данные машины ---
        |Название: $name
        |ID: $id
        |Тип: $type
        |Статус: $status
        |Время работы: ${formatTime(worktime * 60)}
        |---------------------
        """.trimMargin()
    )

    formatTime(600)
}