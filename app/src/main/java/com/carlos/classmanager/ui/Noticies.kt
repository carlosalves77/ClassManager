package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityNoticiesBinding

class Noticies : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityNoticiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNoticiesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backNoticeBtn.setOnClickListener(this)
        getNoticeInfo()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.backNoticeBtn -> {
                startActivity(Intent(this, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        }
    }

    private fun getNoticeInfo() {
        binding.noticeTitle.text = intent.getStringExtra("title")
        binding.dateText.text = intent.getStringExtra("date")
        binding.noticeDescriptionText.text = intent.getStringExtra("description")
        Glide.with(this).load(intent.getStringExtra("noticePicture")!!).into(binding.imageNotice)

    }

}