package com.carlos.classmanager.presentation.adapter


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.carlos.classmanager.R
import com.carlos.classmanager.cammon.utils.IsLoading
import com.carlos.classmanager.databinding.ActivityHomeBinding
import com.carlos.classmanager.databinding.NoticeboardRowBinding
import com.carlos.classmanager.domain.model.Notices
import com.carlos.classmanager.presentation.ui.Noticies

class NoticeAdapter(private var mNotices: List<Notices>, private val binding: ActivityHomeBinding) :
    RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {


    inner class NoticeViewHolder(val binding: NoticeboardRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(
            NoticeboardRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val currentNotice = mNotices[position]
        holder.binding.apply {
            Glide.with(holder.itemView.context).load(mNotices[position].logo)
                .into(imgNoticeBoard)

            noticeTxt.text = mNotices[position].title
            dateTxt.text = mNotices[position].date
            noticeBoard.setOnClickListener {
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

    }

    override fun getItemCount() = mNotices.size

}
