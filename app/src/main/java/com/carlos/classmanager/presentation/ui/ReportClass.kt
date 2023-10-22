package com.carlos.classmanager.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityReportClassBinding
import com.carlos.classmanager.presentation.ui.Home.Home

class ReportClass : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityReportClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReportClassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.reportClassbackBtn.setOnClickListener(this)
        binding.firstClassOnClick.setOnClickListener(this)
        binding.secondClassOnClick.setOnClickListener(this)
        handleBackButton()


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.reportClassbackBtn -> {
                startActivity(Intent(this, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }

            R.id.firstClassOnClick -> {
                startActivity(Intent(this, ReportCard::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
            R.id.secondClassOnClick -> {
                startActivity(Intent(this, ReportCard::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@ReportClass, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }


}

