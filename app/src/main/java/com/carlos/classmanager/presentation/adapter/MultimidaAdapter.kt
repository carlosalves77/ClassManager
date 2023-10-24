package com.carlos.classmanager.presentation.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.databinding.MultimediaRowBinding
import com.carlos.classmanager.domain.model.Multimedia


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
    override fun onBindViewHolder(holder: MultimediaViewHolder, position: Int) {
        holder.binding.apply {
            when (position) {
                0 -> {
                    typeFileText.text = mMultimedia[position].typeFileText
                }
                1 -> {
                    fileContainerLayout.isVisible = false
                    fileWebViewContainerLayout.isVisible = true
                    videoView.loadData(mMultimedia[position].webViewUrl!!, "text/html", "utf-8")
                    titleFileNameWebView.text = mMultimedia[position].titleWebViewText
                    executeVideo(holder.binding.videoView, position)
                    val context = holder.itemView.context as Activity

                }
                2 -> {
                    typeFileText.text = mMultimedia[position].typeFileText
                }
            }
        }


    }

    override fun getItemCount() = mMultimedia.size

    @SuppressLint("SetJavaScriptEnabled")
    private fun executeVideo(videoUrl: WebView, position: Int) {
    videoUrl.settings.javaScriptEnabled = true
        videoUrl.webChromeClient = object  : WebChromeClient() {
            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                super.onShowCustomView(view, callback)
            }

            override fun onHideCustomView() {
                super.onHideCustomView()
            }
        }
    }
}