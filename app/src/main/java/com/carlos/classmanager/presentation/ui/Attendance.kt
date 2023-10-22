package com.carlos.classmanager.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.presentation.adapter.AttendanceAdapter
import com.carlos.classmanager.databinding.ActivityAttendanceBinding
import com.carlos.classmanager.domain.model.Attendance
import com.carlos.classmanager.presentation.ui.Home.Home

class Attendance : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAttendanceBinding

    private var mAttendance = ArrayList<Attendance>()
    private lateinit var mAdapterAttendance: AttendanceAdapter

    private var onClickOpen = true
    private var onClickOpenTwo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAttendanceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtnAttendance.setOnClickListener(this)
        binding.icOpen.setOnClickListener(this)
        binding.icOpenTwo.setOnClickListener(this)

        handleBackButton()
        setAttendanceRvOne()
        setAttendanceRvTwo()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.backBtnAttendance -> {
                startActivity(Intent(this, Home::class.java))
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }

            R.id.ic_open -> {
                handleHideRecyclerViewOne()
            }
            R.id.ic_openTwo -> {
                handleHideRecyclerViewTwo()
            }
        }
    }


    private fun handleBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(this@Attendance, Home::class.java))
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        })
    }

    private fun setAttendanceRvOne() {
        val recyclerViewCalendar = binding.rvAttendanceOne
        recyclerViewCalendar.setHasFixedSize(true)
        recyclerViewCalendar.layoutManager = LinearLayoutManager(this)

        mAdapterAttendance = AttendanceAdapter(mAttendance)
        recyclerViewCalendar.adapter = mAdapterAttendance

        addAttendanceList()
    }

    private fun setAttendanceRvTwo() {
        val recyclerViewCalendar = binding.rvAttendanceTwo
        recyclerViewCalendar.setHasFixedSize(true)
        recyclerViewCalendar.layoutManager = LinearLayoutManager(this)

        mAdapterAttendance = AttendanceAdapter(mAttendance)
        recyclerViewCalendar.adapter = mAdapterAttendance

        addAttendanceList()
    }

    private fun addAttendanceList() {
        mAttendance.add(Attendance("20", "1", "0", "JAN"))
        mAttendance.add(Attendance("18", "1", "0", "FEV"))
        mAttendance.add(Attendance("20", "1", "0", "MAR"))
        mAttendance.add(Attendance("19", "1", "0", "ABR"))
        mAttendance.add(Attendance("20", "1", "0", "MAI"))
        mAttendance.add(Attendance("18", "1", "0", "JUN"))
        mAttendance.add(Attendance("20", "1", "0", "JUL"))
        mAttendance.add(Attendance("19", "1", "0", "AGO"))
        mAttendance.add(Attendance("18", "1", "0", "SET"))
        mAttendance.add(Attendance("20", "1", "0", "OUT"))
        mAttendance.add(Attendance("18", "1", "0", "NOV"))
        mAttendance.add(Attendance("20", "1", "0", "DEZ"))
    }

    private fun handleHideRecyclerViewOne() {

        if (onClickOpen) {
            binding.icOpen.setImageResource(R.drawable.arrow_right)
            binding.rvAttendanceOne.isVisible = true
        } else {

            binding.icOpen.setImageResource(R.drawable.ic_arrow_down)
            binding.rvAttendanceOne.isVisible = false
        }

        onClickOpen = !onClickOpen
    }

    private fun handleHideRecyclerViewTwo() {

        if (onClickOpenTwo) {
            binding.icOpenTwo.setImageResource(R.drawable.arrow_right)
            binding.rvAttendanceTwo.isVisible = true
        } else {

            binding.icOpenTwo.setImageResource(R.drawable.ic_arrow_down)
            binding.rvAttendanceTwo.isVisible = false
        }

        onClickOpenTwo = !onClickOpenTwo
    }

}