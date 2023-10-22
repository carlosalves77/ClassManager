package com.carlos.classmanager.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityProfileBinding
import com.carlos.classmanager.presentation.ui.Home.Home
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.backBtnProfile.setOnClickListener(this)
        binding.SignOutBtn.setOnClickListener(this)
        handleBackButton()
        getAccountInfo()


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.backBtnProfile -> {
                startActivity(Intent(this, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
            R.id.SignOutBtn -> {
                startActivity(Intent(this, SignIn::class.java ))
                auth.signOut()
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                finish()
            }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Profile, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)

            }
        })
    }

    private fun getAccountInfo() {

        if (auth.currentUser != null) {
            binding.namePerfil.text = auth.currentUser?.displayName
            binding.emailPerfil.text = auth.currentUser?.email
            Glide.with(this).load(auth.currentUser?.photoUrl).into(binding.imgProfile)
        }

    }
}