package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityMenuBinding

class Menu : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        @Suppress("DEPRECATION")
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.icClose.setOnClickListener(this)
        binding.sighOutBtn.setOnClickListener(this)
        binding.calendarBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when (v!!.id) {
           R.id.ic_close -> {
               finish()
           }
           R.id.sighOutBtn -> {
              startActivity(Intent(this, SignIn::class.java ))
               finish()
           }
           R.id.calendarBtn -> {
               startActivity(Intent(this, Calendar::class.java))
               finish()
           }
       }

    }
}