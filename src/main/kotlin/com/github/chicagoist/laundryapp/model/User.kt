package com.github.chicagoist.laundryapp.model

// Делаем класс data class'ом и добавляем первичный конструктор.
// Параметр 'id' нужен для однозначной идентификации пользователя в очереди.
data class User(val id: Int, val name: String)
//Обоснование: data class автоматически генерирует полезные методы (equals(),
// hashCode(), toString(), copy()), которые критически важны для работы с
// коллекциями (а наша очередь — это коллекция).