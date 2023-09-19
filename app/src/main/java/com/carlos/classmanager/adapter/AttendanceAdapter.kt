package com.carlos.classmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.AttendanceRowBinding
import com.carlos.classmanager.databinding.CalendarRowBinding
import com.carlos.classmanager.model.Attendance


class AttendanceAdapter(private var mAttendance: List<Attendance>) : RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    inner class AttendanceViewHolder(val binding: AttendanceRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        return AttendanceViewHolder(AttendanceRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AttendanceAdapter.AttendanceViewHolder, position: Int) {
        holder.binding.presentsDays.text = mAttendance[position].present
        holder.binding.absentsDays.text = mAttendance[position].absent
        holder.binding.leavesDays.text = mAttendance[position].leave
        holder.binding.mouthText.text = mAttendance[position].mouth

    }

    override fun getItemCount() = mAttendance.size
}