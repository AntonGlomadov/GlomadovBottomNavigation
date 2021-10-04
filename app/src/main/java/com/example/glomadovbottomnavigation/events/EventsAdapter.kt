package com.example.glomadovbottomnavigation.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.glomadovbottomnavigation.databinding.ItemEventBinding
import com.example.glomadovbottomnavigation.models.event.EventReminder

class EventsAdapter: RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    private var data = listOf<EventReminder>()

    class ViewHolder private constructor(
        private var binding: ItemEventBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: EventReminder,
        ) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.desc
            binding.tvDate.text = item.dateStart.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemEventBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return ViewHolder(binding)
            }
        }
    }

    fun refreshEvents(events: List<EventReminder>) {
        this.data = events
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.bind(item)
    }


    override fun getItemCount() = data.size
}