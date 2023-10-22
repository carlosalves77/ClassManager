package com.carlos.classmanager.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.presentation.adapter.MultimediaAdapter
import com.carlos.classmanager.databinding.ActivityMultimediaBinding
import com.carlos.classmanager.domain.model.Multimedia
import com.carlos.classmanager.presentation.ui.Home.Home
import com.carlos.classmanager.cammon.utils.ListOfMultimedia

class Multimedia : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMultimediaBinding
    private lateinit var multimediaAdapter: MultimediaAdapter
    private var mMultimedia = ArrayList<Multimedia>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultimediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.multimidiaBackBtn.setOnClickListener(this)

        handleBackButton()
        setMultimediaRv()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.multimidiaBackBtn -> {
                startActivity(Intent(this, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        }
    }

    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Multimedia, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        })
    }

    private fun setMultimediaRv() {
        val recyclerViewMultimedia = binding.multimidiaRv
        recyclerViewMultimedia.setHasFixedSize(true)
        recyclerViewMultimedia.layoutManager = LinearLayoutManager(this)

        multimediaAdapter = MultimediaAdapter(mMultimedia)
        recyclerViewMultimedia.adapter = multimediaAdapter

        addMultimediaList()
    }

    private fun addMultimediaList() {

        val listOfMultimedia = ListOfMultimedia()

        mMultimedia.addAll(listOfMultimedia.listMultimediaOne)


    }


}