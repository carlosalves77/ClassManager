package com.carlos.classmanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityFeeBinding

class Fee : AppCompatActivity() {

    private lateinit var binding: ActivityFeeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}