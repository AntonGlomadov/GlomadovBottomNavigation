package com.example.glomadovbottomnavigation.models.event

import java.time.LocalDate

data class EventReminder(
    var title: String,
    var desc: String,
    var dateStart: LocalDate
)
