package com.carlos.classmanager.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.presentation.adapter.ExaminationListTestAdapter
import com.carlos.classmanager.databinding.ActivityExaminationTesteBinding
import com.carlos.classmanager.domain.model.Questions
import com.carlos.classmanager.cammon.utils.ListOfQuestions

class ExaminationTeste : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityExaminationTesteBinding

    private var mQuestions = ArrayList<Questions>()

    private lateinit var adapterQuestions: ExaminationListTestAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityExaminationTesteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.examinationTitle.text = intent?.getStringExtra("examinationTestTxt")
        binding.examinationTesteBackBtn.setOnClickListener(this)
        setExaminationRv()
        handleBackButton()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.examinationTesteBackBtn -> {
                startActivity(Intent(this, Examination::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        }
    }


    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@ExaminationTeste, Examination::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }

    private fun setExaminationRv() {
        val recyclerViewNotice = binding.questionsListRv
        recyclerViewNotice.setHasFixedSize(true)
        recyclerViewNotice.layoutManager =
            LinearLayoutManager(this)

        adapterQuestions = ExaminationListTestAdapter(mQuestions)
        recyclerViewNotice.adapter = adapterQuestions

        addQuestionsList()
    }

    private fun addQuestionsList() {
        val listOfQuestions = ListOfQuestions()

        val selectedList = when (intent?.getIntExtra("id", 0)) {
            1 -> listOfQuestions.firstList
            2 -> listOfQuestions.secondList
            3 -> listOfQuestions.thirdList
            4 -> listOfQuestions.fourthList
            5 -> listOfQuestions.fifthList
            6 -> listOfQuestions.sixthList
            7 -> listOfQuestions.seventhList
            8 -> listOfQuestions.eighthList

            else -> emptyList()
        }

        mQuestions.addAll(selectedList)

    }


}