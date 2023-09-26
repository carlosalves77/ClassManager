package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityExaminationBinding

class Examination : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityExaminationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityExaminationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       binding.examinationBackBtn.setOnClickListener(this)
        handleBackButton()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.examinationBackBtn -> {
                startActivity(Intent(this, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Examination, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }
}