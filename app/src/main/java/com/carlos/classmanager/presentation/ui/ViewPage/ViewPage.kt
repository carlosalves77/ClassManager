package com.carlos.classmanager.presentation.ui.ViewPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityViewPageBinding
import com.carlos.classmanager.presentation.adapter.ViewPageAdapter


class ViewPage : AppCompatActivity() {


    private var titlesList = mutableListOf<String>()
    private var color = mutableListOf<Int>()
    private var imageOnBoarding = mutableListOf<Int>()



    private lateinit var binding: ActivityViewPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityViewPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.viewPage2.adapter = ViewPageAdapter(titlesList, color, imageOnBoarding)
        binding.viewPage2.orientation =  ViewPager2.ORIENTATION_HORIZONTAL

        postToList()
    }

    private fun addToList(title: String, backgroundColor: Int, image: Int) {
        titlesList.add(title)
        color.add(backgroundColor)
        imageOnBoarding.add(image)
    }

    private fun postToList() {
        addToList("Marcar tarefa quando concluída", R.color.yellow, R.drawable.onboarding1)
        addToList("Acompanhe seu comparecimento", R.color.blueClean, R.drawable.onboarding2)
        addToList("Exames & Boletins de Alunos", R.color.pinkClean, R.drawable.onboarding3)
    }


}