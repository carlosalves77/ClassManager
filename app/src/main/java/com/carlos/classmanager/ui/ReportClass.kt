package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ReportFragment
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityReportClassBinding

class ReportClass : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityReportClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReportClassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.reportClassbackBtn.setOnClickListener(this)
        binding.firstClassOnClick.setOnClickListener(this)
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

