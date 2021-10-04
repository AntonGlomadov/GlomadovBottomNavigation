package com.example.glomadovbottomnavigation.models.event

import java.time.LocalDate

data class EventReminder(
    val title: String,
    val desc: String,
    val dateStart: LocalDate
)
