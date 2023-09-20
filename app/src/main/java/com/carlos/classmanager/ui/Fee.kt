package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R

import com.carlos.classmanager.adapter.FeeAdapter
import com.carlos.classmanager.databinding.ActivityFeeBinding
import com.carlos.classmanager.model.Fee


class Fee : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityFeeBinding

    private var mFee = ArrayList<Fee>()

    private lateinit var adapterFee: FeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFeeRv()
        handleBackButton()
        binding.feeBackBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when (v!!.id) {
           R.id.feeBackBtn -> {
               startActivity(Intent(this, Home::class.java))
               overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
               finish()
           }
       }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Fee, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }
    private fun setFeeRv() {
        val recyclerViewCalendar = binding.feeRv
        recyclerViewCalendar.setHasFixedSize(true)
        recyclerViewCalendar.layoutManager = LinearLayoutManager(this)

        adapterFee = FeeAdapter(mFee)
        recyclerViewCalendar.adapter = adapterFee

        addFeeList()
    }

    private fun addFeeList() {
        mFee.add(Fee("R$ 600", "Boleto de Janeiro"))
        mFee.add(Fee("R$ 600", "Boleto de Fevereiro "))
        mFee.add(Fee("R$ 600", "Boleto de Março"))
        mFee.add(Fee("R$ 600", "Boleto de Abril"))
        mFee.add(Fee("R$ 600", "Boleto de Maio"))
        mFee.add(Fee("R$ 600", "Boleto de Junho"))
        mFee.add(Fee("R$ 600", "Boleto de Julho"))
        mFee.add(Fee("R$ 600", "Boleto de Agosto"))
        mFee.add(Fee("R$ 600", "Boleto de Setembro"))
        mFee.add(Fee("R$ 600", "Boleto de Outubro"))
        mFee.add(Fee("R$ 600", "Boleto de Novembro"))
        mFee.add(Fee("R$ 600", "Boleto de Dezembro"))
    }

}