package com.carlos.classmanager.adapter


import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.NoticeboardRowBinding
import com.carlos.classmanager.model.Notices
import com.carlos.classmanager.ui.Noticies

class NoticeAdapter(private var mNotices: List<Notices>) : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {


    inner class NoticeViewHolder(val binding: NoticeboardRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(NoticeboardRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val currentNotice = mNotices[position]
        holder.binding.imgNoticeBoard.setImageResource(mNotices[position].logo)
        holder.binding.noticeTxt.text = mNotices[position].title
        holder.binding.dateTxt.text = mNotices[position].date
        holder.binding.navNoticiesBtn.setOnClickListener {
             val intent = Intent(holder.itemView.context, Noticies::class.java)
             intent.putExtra("title", currentNotice.title)
             intent.putExtra("date", currentNotice.date)
             intent.putExtra("description", currentNotice.description)
             intent.putExtra("noticePicture", currentNotice.noticePicture)
             holder.itemView.context.startActivity(intent)

            val context = holder.itemView.context as Activity
            context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
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