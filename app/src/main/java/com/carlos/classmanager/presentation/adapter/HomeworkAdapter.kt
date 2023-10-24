package com.carlos.classmanager.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.HomeworkRowBinding
import com.carlos.classmanager.domain.model.HomeWork
import com.carlos.classmanager.cammon.utils.HomeworkIdSingleton

class HomeworkAdapter : RecyclerView.Adapter<HomeworkAdapter.HomeworkViewHolder>() {

    private var mHomework = emptyList<HomeWork>()

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
    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {

        val currentHomework = mHomework[position]

        holder.binding.apply {
            homeworkTitle.text = mHomework[position].description
            homeWorkDate.text = mHomework[position].date

            if (homeworkTitle.text.length > 30) {
                homeworkTitle.text = homeworkTitle.text.substring(0,21) + "..."
            }
        }

        HomeworkIdSingleton.homeworkId = currentHomework.id
        HomeworkIdSingleton.title = currentHomework.description
        HomeworkIdSingleton.dateHomework = currentHomework.date.toString()
        HomeworkIdSingleton.titleDescription = currentHomework.descriptionText

    }

    override fun getItemCount() = mHomework.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newHomeWork: List<HomeWork>) {
        this.mHomework = newHomeWork
        notifyDataSetChanged()

    }


}