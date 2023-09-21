package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityReportCardBinding

class ReportCard : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityReportCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReportCardBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        handleBackButton()
        binding.reportClassCardbackBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.reportClassCardbackBtn -> {
                startActivity(Intent(this, ReportClass::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@ReportCard, ReportClass::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }
}