package com.carlos.classmanager.presentation.ui.Homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.carlos.classmanager.R
import com.carlos.classmanager.cammon.utils.HomeworkIdSingleton
import com.carlos.classmanager.databinding.ActivityEditNoteBinding
import com.carlos.classmanager.presentation.ui.Home.Home

class EditNote : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityEditNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.editBtn.setOnClickListener(this)
        binding.saveBtn.setOnClickListener(this)
        binding.backBtnAddHomework.setOnClickListener(this)

        handleBackButton()
        getHomeWorkInfo()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.saveBtn -> {

            }

            R.id.editBtn -> {

            }

            R.id.backBtnAddHomework -> {
                startActivity(Intent(this@EditNote, Home::class.java))
                finish()
            }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@EditNote, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        })
    }

    private fun getHomeWorkInfo() {

        binding.etHomeworkTitleEditView.focusable = View.NOT_FOCUSABLE
        binding.etHomeworkTitleEditView.isFocusableInTouchMode = false

        binding.etHomeworkDescriptionView.focusable = View.NOT_FOCUSABLE
        binding.etHomeworkDescriptionView.isFocusableInTouchMode = false

        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val titleDescription = intent.getStringExtra("titleDescription")
        binding.dateTxt.text = date
        binding.etHomeworkTitleEditView.setText(title)
        binding.etHomeworkDescriptionView.setText(titleDescription)


    }
}