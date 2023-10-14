package com.carlos.classmanager.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.HomeworkRowBinding
import com.carlos.classmanager.databinding.NoticeboardRowBinding
import com.carlos.classmanager.model.HomeWork
import com.carlos.classmanager.model.Notices

class HomeworkAdapter(private var mHomework: List<HomeWork>) :
    RecyclerView.Adapter<HomeworkAdapter.HomeworkViewHolder>() {

    inner class HomeworkViewHolder(val binding: HomeworkRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        return HomeworkViewHolder(
            HomeworkRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeworkAdapter.HomeworkViewHolder, position: Int) {

        holder.binding.apply {
             homeworkTitle.text = mHomework[position].homeworkTitle
            if (homeworkTitle.text.length > 30) {
                homeworkTitle.text = homeworkTitle.text.substring(0,21) + "..."
            }
            homeWorkDate.text = mHomework[position].date
        }
    }

    override fun getItemCount() = mHomework.size
}