package com.carlos.classmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.CalendarRowBinding
import com.carlos.classmanager.model.Calendar

class MultimidaAdapter(private var mCalendar: List<Calendar>) : RecyclerView.Adapter<MultimidaAdapter.CalendarViewHolder>() {

    inner class CalendarViewHolder(val binding: CalendarRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder(CalendarRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MultimidaAdapter.CalendarViewHolder, position: Int) {
        holder.binding.dayText.text = mCalendar[position].day
        holder.binding.mouthText.text = mCalendar[position].mouth
        holder.binding.eventName.text = mCalendar[position].eventName
        holder.binding.eventType.text = mCalendar[position].eventType
    }

    override fun getItemCount() = mCalendar.size
}