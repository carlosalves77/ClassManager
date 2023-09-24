package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityReportCardBinding
import com.google.firebase.auth.FirebaseAuth

class ReportCard : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityReportCardBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReportCardBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.reportClassCardbackBtn.setOnClickListener(this)
        handleBackButton()
        getAccountInfo()
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

    private fun getAccountInfo() {

        if (auth.currentUser != null) {
            binding.txtName.text = auth.currentUser?.displayName
            Glide.with(this).load(auth.currentUser?.photoUrl).into(binding.imgProfile)
        }

    }
}