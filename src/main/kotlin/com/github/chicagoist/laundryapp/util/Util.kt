package com.github.chicagoist.laundryapp.util

fun formatTime(totalSeconds: Int) : String {

    if (totalSeconds < 0) return "00:00"

    val hours = totalSeconds / 3600
    val secondsForMinutes = totalSeconds % 3600
    val minutes = secondsForMinutes / 60
    val seconds = secondsForMinutes % 60

    val hoursFormatted = hours.toString().padStart(2, '0')
    val minutesFormatted = minutes.toString().padStart(2, '0')
    val secondsFormatted = seconds.toString().padStart(2, '0')

    val countdown : String = "${hoursFormatted}:${minutesFormatted}:${secondsFormatted}"










    println(countdown)

    return countdown
}