package com.github.chicagoist.laundryapp.app

import com.github.chicagoist.laundryapp.util.formatTime


fun main() {
    val status: String
    var washerUsageCount = 0
    var dryerUsageCount = 0

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
    if (choice == null || choice != 1) {
        println("Ошибка: машина должна быть в состоянии 'working'!")
        return
    } else {
        status = "working"
    }

    print("Время работы в минутах: ")
    val worktime = readln().toIntOrNull()

    // STRICT SECURE-FIRST: проверка на null и положительное значение
    if (worktime == null) {
        println("Ошибка: введите число!")
        return
    }
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

    // Увеличение счётчика только после успешной валидации
    if (machine == "washer") {
        washerUsageCount += 1
    } else {
        dryerUsageCount += 1
    }

    println(
        """
        |--- Данные машины ---
        |Машина: $machine
        |Состояние: $status
        |Время работы: ${formatTime(worktime)}
        |Количество использований: ${if (machine == "washer") washerUsageCount else dryerUsageCount}
        |---------------------
        """.trimMargin()
    )
}