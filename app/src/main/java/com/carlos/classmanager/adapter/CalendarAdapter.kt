package com.carlos.classmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.CalendarRowBinding
import com.carlos.classmanager.model.Calendar

class CalendarAdapter(private var mCalendar: List<Calendar>) :
    RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    inner class CalendarViewHolder(val binding: CalendarRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder(
            CalendarRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CalendarAdapter.CalendarViewHolder, position: Int) {
        holder.binding.apply {
            dayText.text = mCalendar[position].day
            mouthText.text = mCalendar[position].mouth
            eventName.text = mCalendar[position].eventName
            eventType.text = mCalendar[position].eventType
        }

    }

    override fun getItemCount() = mCalendar.size
}