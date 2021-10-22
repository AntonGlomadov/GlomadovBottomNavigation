package com.example.glomadovbottomnavigation.events

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glomadovbottomnavigation.models.event.EventReminder
import com.example.glomadovbottomnavigation.models.event.EventReminderDataObject
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class EventsViewModel : ViewModel() {
    private val eventsList: MutableLiveData<List<EventReminder>> = MutableLiveData()
    private var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    init {
        eventsList.value = EventReminderDataObject.getEvents()
    }

    fun getEventList() = eventsList

}