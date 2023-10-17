package com.carlos.classmanager.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.MultimediaRowBinding
import com.carlos.classmanager.model.Multimedia


class MultimediaAdapter(private var mMultimedia: List<Multimedia>) :
    RecyclerView.Adapter<MultimediaAdapter.MultimediaViewHolder>() {

    inner class MultimediaViewHolder(val binding: MultimediaRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultimediaViewHolder {
        return MultimediaViewHolder(
            MultimediaRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onBindViewHolder(holder: MultimediaAdapter.MultimediaViewHolder, position: Int) {
        holder.binding.apply {
            when (position) {
                0 -> {
                    typeFileText.text = mMultimedia[position].typeFileText
                }
                1 -> {
                    fileContainerLayout.isVisible = false
                    fileWebViewContainerLayout.isVisible = true
                    titleFileNameWebView.text = mMultimedia[position].titleWebViewText
                    val context = holder.itemView.context as Activity

                }
                2 -> {
                    typeFileText.text = mMultimedia[position].typeFileText
                }
            }
        }


    }

    override fun getItemCount() = mMultimedia.size
}