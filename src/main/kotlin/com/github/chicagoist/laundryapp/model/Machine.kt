package com.github.chicagoist.laundryapp.model

// Также превращаем в data class. Параметр 'isAvailable' лучше сделать var,
// так как состояние машины будет меняться в runtime.
data class Machine(val id: Int, val name: String, val type: MachineType, var isAvailable: Boolean = true)

// Используем enum class для строгого ограничения типов машин.
// Это лучше, чем просто String, исключает опечатки и яснее выражает intent.
enum class MachineType {
    WASHER, DRYER
}
/*Обоснование: enum class — это типобезопасный и современный способ задания
ограниченного набора значений. Изменяемое isAvailable необходимо для логики
работы.*/