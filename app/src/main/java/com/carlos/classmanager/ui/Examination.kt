package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.adapter.ExaminationAdapter
import com.carlos.classmanager.databinding.ActivityExaminationBinding
import com.carlos.classmanager.model.Examination


class Examination : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityExaminationBinding

    private var mExamination = ArrayList<Examination>()

    private lateinit var adapterExamination: ExaminationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityExaminationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       binding.examinationBackBtn.setOnClickListener(this)
        setExaminationRv()
        handleBackButton()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.examinationBackBtn -> {
                startActivity(Intent(this, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Examination, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }

    private fun setExaminationRv() {
        val recyclerViewNotice = binding.examinationRv
        recyclerViewNotice.setHasFixedSize(true)
        recyclerViewNotice.layoutManager =
            LinearLayoutManager(this)

        adapterExamination = ExaminationAdapter(mExamination)
        recyclerViewNotice.adapter = adapterExamination

        addExaminationList()
    }

    private fun addExaminationList() {
        mExamination.add(Examination(
            "Sistema Solar Explorado",
            "1º Questão (1 alternativa)",
            "Qual é o planeta mais próximo do Sol no nosso sistema solar? Este planeta é conhecido por suas temperaturas extremamente altas durante o dia e extremamente baixas durante a noite, devido à falta de uma atmosfera significativa. Qual é o nome desse planeta?",
            "Vênus",
            "Terra",
            "Mercúrio",
            "Júpiter"

        ))
        mExamination.add(Examination("Revolução Industrial Impacto"))
        mExamination.add(Examination("Guerra Civil Americana"))
        mExamination.add(Examination("Geometria em Ação"))
        mExamination.add(Examination("Evolução das Espécies"))
        mExamination.add(Examination("Literatura Clássica Analisada"))
        mExamination.add(Examination("Meio Ambiente Preservado"))
        mExamination.add(Examination("Arte Moderna Expressiva"))
    }
}