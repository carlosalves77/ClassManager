package com.carlos.classmanager.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.AttendanceRowBinding
import com.carlos.classmanager.databinding.CalendarRowBinding
import com.carlos.classmanager.domain.model.Attendance


class AttendanceAdapter(private var mAttendance: List<Attendance>) : RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    inner class AttendanceViewHolder(val binding: AttendanceRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        return AttendanceViewHolder(AttendanceRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        holder.binding.apply {
            presentsDays.text = mAttendance[position].present
            absentsDays.text = mAttendance[position].absent
            leavesDays.text = mAttendance[position].leave
            mouthText.text = mAttendance[position].mouth
        }


    }

    override fun getItemCount() = mAttendance.size
}