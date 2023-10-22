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
import com.carlos.classmanager.databinding.QuestionsRowBinding
import com.carlos.classmanager.domain.model.Attendance
import com.carlos.classmanager.domain.model.Examination
import com.carlos.classmanager.domain.model.Questions
import com.carlos.classmanager.presentation.ui.ExaminationTeste
import com.carlos.classmanager.presentation.ui.Noticies


class ExaminationListTestAdapter(private var mQuestions: List<Questions>) :
    RecyclerView.Adapter<ExaminationListTestAdapter.ExaminationListTestViewHolder>() {

    inner class ExaminationListTestViewHolder(val binding: QuestionsRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExaminationListTestViewHolder {
        return ExaminationListTestViewHolder(
            QuestionsRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExaminationListTestViewHolder, position: Int) {
        holder.binding.apply {
            questionNumberTxt.text = mQuestions[position].questionNumber
            textQuestion.text = mQuestions[position].questionText
            questionOneTxt.text = mQuestions[position].firstQuestion
            questionTwoTxt.text = mQuestions[position].secondQuestion
            questionThirdTxt.text = mQuestions[position].thirdQuestion
            questionFourthTxt.text = mQuestions[position].fourthQuestion
            questionFifthTxt.text = mQuestions[position].fifthQuestion
        }
    }

    override fun getItemCount() = mQuestions.size
}