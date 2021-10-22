package com.example.glomadovbottomnavigation.events

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.glomadovbottomnavigation.R
import com.example.glomadovbottomnavigation.databinding.FragmentEventsBinding
import androidx.navigation.fragment.findNavController

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding
    private val viewModel: EventsViewModel by lazy { ViewModelProvider(this).get(EventsViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var adapter = EventsAdapter()
        binding = FragmentEventsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvEvents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvEvents.adapter = adapter
        binding.fabAddEvent.setOnClickListener {
            findNavController().navigate(R.id.action_events_to_add_event)
        }
        viewModel.getEventList().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.refreshEvents(it)
            }
        })
        return binding.root
    }


}