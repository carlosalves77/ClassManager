package com.carlos.classmanager.presentation.ui.Menu


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityMenuBinding
import com.carlos.classmanager.presentation.ui.Attendance
import com.carlos.classmanager.presentation.ui.Calendar
import com.carlos.classmanager.presentation.ui.Examination
import com.carlos.classmanager.presentation.ui.Fee
import com.carlos.classmanager.presentation.ui.Home.Home
import com.carlos.classmanager.presentation.ui.Multimedia
import com.carlos.classmanager.presentation.ui.Profile
import com.carlos.classmanager.presentation.ui.ReportClass
import com.google.firebase.auth.FirebaseAuth

class Menu : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.icClose.setOnClickListener(this)
        binding.calendarBtn.setOnClickListener(this)
        binding.profileBtn.setOnClickListener(this)
        binding.attendanceLayout.setOnClickListener(this)
        binding.feeLayout.setOnClickListener(this)
        binding.multidiaLayout.setOnClickListener(this)
        binding.reportClassLayout.setOnClickListener(this)
        binding.homeWorkLayout.setOnClickListener(this)

        getAccountInfo()
        handleBackButton()
    }


    override fun onClick(v: View?) {
       when (v!!.id) {
           R.id.ic_close -> {
               startActivity(Intent(this, Home::class.java ))
               overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
               finish()
           }
           R.id.calendarBtn -> {
               startActivity(Intent(this, Calendar::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
           R.id.profileBtn -> {
               startActivity(Intent(this, Profile::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
           R.id.attendanceLayout -> {
               startActivity(Intent(this, Attendance::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
           R.id.feeLayout -> {
               startActivity(Intent(this, Fee::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
           R.id.multidiaLayout -> {
               startActivity(Intent(this, Multimedia::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
           R.id.reportClassLayout -> {
               startActivity(Intent(this, ReportClass::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }R.id.homeWorkLayout -> {
               startActivity(Intent(this, Examination::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
       }

    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Menu, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }


    private fun getAccountInfo() {

        if (auth.currentUser != null) {
            val nameProfile = auth.currentUser?.displayName
            val profileUrl = auth.currentUser?.photoUrl
            binding.nameTeacherText.text = nameProfile
            Glide.with(this).load(profileUrl).into(binding.imgProfile)
        }

    }
}