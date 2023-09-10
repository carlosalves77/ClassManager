package com.carlos.classmanager.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityMenuBinding
import com.google.firebase.auth.FirebaseAuth

class Menu : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        @Suppress("DEPRECATION")
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        auth = FirebaseAuth.getInstance()

        binding.icClose.setOnClickListener(this)
        binding.sighOutBtn.setOnClickListener(this)
        binding.calendarBtn.setOnClickListener(this)

        getAccountInfo()

    }

    override fun onClick(v: View?) {
       when (v!!.id) {
           R.id.ic_close -> {
               finish()
           }
           R.id.sighOutBtn -> {
              startActivity(Intent(this, SignIn::class.java ))
               auth.signOut()
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
           R.id.calendarBtn -> {
               startActivity(Intent(this, Calendar::class.java))
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
               finish()
           }
       }

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