package com.github.chicagoist.laundryapp.util

fun formatTime(totalMinutes: Int): String {
    if (totalMinutes < 0) return "00:00"

    val hours = totalMinutes / 60
    val minutes = totalMinutes % 60

    val hoursFormatted = hours.toString().padStart(2, '0')
    val minutesFormatted = minutes.toString().padStart(2, '0')

    return "$hoursFormatted:$minutesFormatted"
}