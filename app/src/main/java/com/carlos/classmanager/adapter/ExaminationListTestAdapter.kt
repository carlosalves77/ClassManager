package com.carlos.classmanager.adapter

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
import com.carlos.classmanager.model.Attendance
import com.carlos.classmanager.model.Examination
import com.carlos.classmanager.ui.ExaminationTeste
import com.carlos.classmanager.ui.Noticies


class ExaminationListTestAdapter(private var mExaminationTestList: List<Examination>) :
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

    override fun onBindViewHolder(holder: ExaminationListTestAdapter.ExaminationListTestViewHolder, position: Int) {
        holder.binding.apply {
            textQuestion.text = mExaminationTestList[position].description
            questionNumberTxt.text = mExaminationTestList[position].questionNumber
            questionOneTxt.text = mExaminationTestList[position].questionNumber
            questionTwoTxt.text = mExaminationTestList[position].secondQuestion
            questionThirdTxt.text = mExaminationTestList[position].thirdQuestion
            questionFourthTxt.text = mExaminationTestList[position].fourthQuestion
            questionFifthTxt.text = mExaminationTestList[position].fifthQuestion
        }
    }

    override fun getItemCount() = mExaminationTestList.size
}