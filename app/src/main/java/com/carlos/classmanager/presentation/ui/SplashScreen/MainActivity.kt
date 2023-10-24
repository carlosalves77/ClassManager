package com.carlos.classmanager.presentation.ui.SplashScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.carlos.classmanager.databinding.ActivityMainBinding
import com.carlos.classmanager.presentation.ui.SignIn
import com.carlos.classmanager.presentation.ui.ViewPage.ViewPage

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN




        Handler(Looper.getMainLooper()).postDelayed({

            val sharedPreferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            val firstTime = sharedPreferences.getString("FirstTimeUsing", "")
            if (firstTime.equals("YES")) {
                startActivity(Intent(this, SignIn::class.java))
                finish()
            } else {
                startActivity(Intent(this, ViewPage::class.java))
                finish()
                val editor = sharedPreferences.edit()
                editor.putString("FirstTimeUsing", "YES")
                editor.apply()
            }


        }, 2000)

    }

}