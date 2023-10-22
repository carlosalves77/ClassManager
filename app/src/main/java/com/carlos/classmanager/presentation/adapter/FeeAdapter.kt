package com.carlos.classmanager.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.FeeRowBinding
import com.carlos.classmanager.domain.model.Fee


class FeeAdapter(private var mFee: List<Fee>) : RecyclerView.Adapter<FeeAdapter.FeeViewHolder>() {

    private var onClickOpen = true
    inner class FeeViewHolder(val binding: FeeRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeeViewHolder {
        return FeeViewHolder(FeeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FeeViewHolder, position: Int) {
        holder.binding.totalValue.text = mFee[position].totalValue
        holder.binding.feeMouth.text = mFee[position].feeMouth
        holder.binding.onClickBtnViewDetails.setOnClickListener {
            handleHideRecyclerViewOne(holder)
        }

    }
    override fun getItemCount() = mFee.size

    private fun handleHideRecyclerViewOne(holder: FeeViewHolder) {

        if (onClickOpen) {
            holder.binding.onClickBtnViewDetails.setImageResource(R.drawable.arrow_right)
            holder.binding.feeOpenValues.isVisible = true
        } else {

            holder.binding.onClickBtnViewDetails.setImageResource(R.drawable.ic_arrow_down)
            holder.binding.feeOpenValues.isVisible = false
        }

        onClickOpen = !onClickOpen
    }
}