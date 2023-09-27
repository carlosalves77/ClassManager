package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.adapter.ExaminationAdapter
import com.carlos.classmanager.adapter.ExaminationListTestAdapter
import com.carlos.classmanager.databinding.ActivityExaminationTesteBinding
import com.carlos.classmanager.model.Questions
import com.carlos.classmanager.utils.firstList
import com.carlos.classmanager.utils.secondList
import com.carlos.classmanager.utils.thirdList

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
        when (intent?.getIntExtra("id", 0)) {
            1 -> {
                for (item in firstList) {
                    mQuestions.add(item)
                }
            }

            2 -> {
                for (item in secondList) {
                    mQuestions.add(item)
                }
            }

            3 -> {
                for (item in thirdList) {
                    mQuestions.add(item)
                }
            }
        }

    }


}