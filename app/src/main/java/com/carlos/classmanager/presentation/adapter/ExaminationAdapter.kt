package com.carlos.classmanager.presentation.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.AttendanceRowBinding
import com.carlos.classmanager.databinding.CalendarRowBinding
import com.carlos.classmanager.databinding.ExaminationRowBinding
import com.carlos.classmanager.domain.model.Attendance
import com.carlos.classmanager.domain.model.Examination
import com.carlos.classmanager.presentation.ui.ExaminationTeste
import com.carlos.classmanager.presentation.ui.Noticies


class ExaminationAdapter(private var mExamination: List<Examination>) :
    RecyclerView.Adapter<ExaminationAdapter.ExaminationViewHolder>() {

    inner class ExaminationViewHolder(val binding: ExaminationRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExaminationViewHolder {
        return ExaminationViewHolder(
            ExaminationRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExaminationViewHolder, position: Int) {
        holder.binding.apply {
            titleNameTxt.text = mExamination[position].description
            when (position) {
                1 -> {
                    completedLayout.isVisible = true
                    startButton.isVisible = false
                    cardExamination.isEnabled = false
                }

                3 -> {
                    completedLayout.isVisible = true
                    startButton.isVisible = false
                    cardExamination.isEnabled = false
                }
                5 -> {
                    completedLayout.isVisible = true
                    startButton.isVisible = false
                    cardExamination.isEnabled = false
                }
                else -> {
                    completedLayout.isVisible = false
                    startButton.isVisible = true
                }

            }
            cardExamination.setOnClickListener {
                val intent = Intent(holder.itemView.context, ExaminationTeste::class.java)
                intent.putExtra("id", mExamination[position].id)
                intent.putExtra("examinationTestTxt", holder.binding.titleNameTxt.text)
                holder.itemView.context.startActivity(intent)
                val context = holder.itemView.context as Activity
                context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }


    }

    override fun getItemCount() = mExamination.size
}