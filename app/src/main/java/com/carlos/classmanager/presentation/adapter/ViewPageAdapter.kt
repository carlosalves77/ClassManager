package com.carlos.classmanager.presentation.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ItemPageviewBinding
import com.carlos.classmanager.presentation.ui.SignIn

class ViewPageAdapter(
    private var title: List<String>,
    private var backgroundColor: List<Int>,
    private var image: List<Int>) :
    RecyclerView.Adapter<ViewPageAdapter.ViewPageViewHolder>() {


    inner class ViewPageViewHolder(val binding: ItemPageviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.TitleImage.setOnClickListener {
                    val position = bindingAdapterPosition
                    Toast.makeText(itemView.context, "You clicked on Item ${position + 1}", Toast.LENGTH_SHORT).show()

                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageViewHolder {
        return ViewPageViewHolder(
            ItemPageviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewPageViewHolder, position: Int) {
        holder.binding.apply {
            TitleImage.text = title[position]
            LayoutViewPage.setBackgroundResource(backgroundColor[position])
            imageOnboarding.setImageResource(image[position])
            when (position) {
                2 -> {
                    nextBtn.visibility = View.VISIBLE
                    letStart.visibility = View.VISIBLE
                }
            }
            nextBtn.setOnClickListener {
                val intent = Intent(holder.itemView.context, SignIn::class.java)
                holder.itemView.context.startActivity(intent)
                val context = holder.itemView.context as Activity
                context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }

    }

    override fun getItemCount() = title.size
}