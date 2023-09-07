package com.carlos.classmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.NoticeboardRowBinding
import com.carlos.classmanager.model.Notices

class NoticeAdapter(var mNotices: List<Notices>) : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    inner class NoticeViewHolder(val binding: NoticeboardRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(NoticeboardRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.binding.imgNoticeBoard.setImageResource(mNotices[position].logo)
        holder.binding.noticeTxt.text = mNotices[position].title
        holder.binding.dateTxt.text = mNotices[position].date
    }

    override fun getItemCount() = mNotices.size

}