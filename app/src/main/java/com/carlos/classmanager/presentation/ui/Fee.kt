package com.carlos.classmanager.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R

import com.carlos.classmanager.presentation.adapter.FeeAdapter
import com.carlos.classmanager.databinding.ActivityFeeBinding
import com.carlos.classmanager.domain.model.Fee
import com.carlos.classmanager.presentation.ui.Home.Home


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
        mFee.add(Fee("R$ 600", "Boleto de Janeiro", "5 Janeiro"))
        mFee.add(Fee("R$ 600", "Boleto de Fevereiro", "5 Fevereiro"))
        mFee.add(Fee("R$ 600", "Boleto de Março", "5 Março"))
        mFee.add(Fee("R$ 600", "Boleto de Abril", "5 Abril"))
        mFee.add(Fee("R$ 600", "Boleto de Maio", "5 Maio"))
        mFee.add(Fee("R$ 600", "Boleto de Junho ", "5 Junho"))
        mFee.add(Fee("R$ 600", "Boleto de Julho", "5 Julho"))
        mFee.add(Fee("R$ 600", "Boleto de Agosto", "5 Agosto"))
        mFee.add(Fee("R$ 600", "Boleto de Setembro", "5 Setembro"))
        mFee.add(Fee("R$ 600", "Boleto de Outubro", "5 Outubro"))
        mFee.add(Fee("R$ 600", "Boleto de Novembro", "5 Novembro"))
        mFee.add(Fee("R$ 600", "Boleto de Dezembro", "5 Dezembro"))
    }

}