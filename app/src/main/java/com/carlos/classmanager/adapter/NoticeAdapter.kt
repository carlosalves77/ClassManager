package com.carlos.classmanager.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.NoticeboardRowBinding
import com.carlos.classmanager.model.Notices

class NoticeAdapter(private var mNotices: List<Notices>) : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    inner class NoticeViewHolder(val binding: NoticeboardRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(NoticeboardRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
//        val color = cores[position % cores.size]
//        holder.binding.noticeBoard.setBackgroundColor(color)
        holder.binding.imgNoticeBoard.setImageResource(mNotices[position].logo)
        holder.binding.noticeTxt.text = mNotices[position].title
        holder.binding.dateTxt.text = mNotices[position].date
    }

    override fun getItemCount() = mNotices.size

}

val cores = listOf(
    R.color.blueClean,
    R.color.purple,
    R.color.greenClean,
    R.color.pinkClean,
    R.color.blue,
    R.color.blueClean,

)