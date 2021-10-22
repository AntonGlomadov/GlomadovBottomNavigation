package com.example.glomadovbottomnavigation.models.event

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

object EventReminderDataObject {
    @RequiresApi(Build.VERSION_CODES.O)
    private var eventsList = mutableListOf<EventReminder>(
        EventReminder("День рождения", "День рождение Ильи", LocalDate.of(2021, 10, 14)),
        EventReminder("Свадьба", "Свалюба лучшего друга", LocalDate.of(2021, 10, 21)),
        EventReminder("День рождения", "День рождение Влада", LocalDate.of(2021, 11, 1)),
        EventReminder("Выезд на природу", "Выезд с друзьями на природу", LocalDate.of(2021, 11, 19)),
        EventReminder("День рождения", "День рождение девушки", LocalDate.of(2021, 12, 16)),
        EventReminder("Новый год", "нг", LocalDate.of(2021, 12, 31)),
    )
    @RequiresApi(Build.VERSION_CODES.O)
    fun getEvents() = eventsList
    @RequiresApi(Build.VERSION_CODES.O)
    fun addEvent(event: EventReminder) {
        eventsList.add(event)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sortEvents() {
        eventsList.sortWith(Comparator { x: EventReminder, y: EventReminder ->
            x.dateStart.compareTo(
                y.dateStart
            )
        })
    }
}