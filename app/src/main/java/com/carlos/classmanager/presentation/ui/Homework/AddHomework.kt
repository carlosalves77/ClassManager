package com.carlos.classmanager.presentation.ui.Homework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityAddHomeworkBinding
import com.carlos.classmanager.domain.model.HomeWork
import com.carlos.classmanager.presentation.ui.Home.Home
import com.carlos.classmanager.presentation.viewModel.AddNoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class AddHomework : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityAddHomeworkBinding
    private val mAddNoteViewModel: AddNoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddHomeworkBinding.inflate(layoutInflater)
        setContentView(binding.root)


        handleBackButton()
        binding.backBtnAddHomework.setOnClickListener(this)
        binding.saveBtn.setOnClickListener(this)


    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.backBtnAddHomework -> {
                startActivity(Intent(this@AddHomework, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }

            R.id.saveBtn -> {
                addHome()
            }

        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@AddHomework, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        })
    }

    @SuppressLint("SimpleDateFormat")
    private fun addHome() {

        val title = binding.etHomeworkTitle.text.toString()
        val titleFirstLatterUpperCase = title.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }
        val titleDescription = binding.etHomeworkDescription.text.toString()
        val titleDescriptionFirstLatterUppercase = titleDescription.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }


        if (inputCheck(title, titleDescription)) {

            val calendar = Calendar.getInstance()
            val currentDate = calendar.time
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val formattedDate = dateFormat.format(currentDate)


            // Create User Object
            val homework = HomeWork(
                0,
                titleFirstLatterUpperCase,
                titleDescriptionFirstLatterUppercase,
                formattedDate
            )
//            // Add Data to Database
            mAddNoteViewModel.addHomework(homework)

            Toast(this).apply {
                setGravity(Gravity.TOP, 1, 1)
                makeText(this@AddHomework, "Tarefa adicionada", Toast.LENGTH_SHORT).show()
            }
            // Navigate Back
            finish()
        } else {
            Toast(this).apply {
                setGravity(Gravity.TOP, 1, 1)
                makeText(this@AddHomework, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inputCheck(titleHomework: String, titleHomeworkDescription: String): Boolean {
        return !(TextUtils.isEmpty(titleHomework) && TextUtils.isEmpty(titleHomeworkDescription))
    }


}