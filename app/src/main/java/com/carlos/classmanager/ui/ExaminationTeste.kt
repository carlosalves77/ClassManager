package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityExaminationTesteBinding

class ExaminationTeste : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityExaminationTesteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityExaminationTesteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.examinationTitle.text = intent?.getStringExtra("examinationTestTxt")
        binding.examinationTesteBackBtn.setOnClickListener(this)
        handleBackButton()
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@ExaminationTeste, Examination::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.examinationTesteBackBtn -> {
                startActivity(Intent(this, Examination::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        }
    }
}