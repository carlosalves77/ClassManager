package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityMultimediaBinding

class Multimedia : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMultimediaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultimediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.multimidiaBackBtn.setOnClickListener(this)

        handleBackButton()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
          R.id.multimidiaBackBtn -> {
              startActivity(Intent(this, Home::class.java))
              overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
              finish()
          }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Multimedia, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        })
    }
}