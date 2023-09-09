package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.adapter.CalendarAdapter
import com.carlos.classmanager.databinding.ActivityCalendarBinding
import com.carlos.classmanager.model.Calendar


class Calendar : AppCompatActivity(), View.OnClickListener {

    private var year: Int = 0
    private var mouth: Int = 0
    private var day: Int = 0

    private var total: Int = 0

    private lateinit var binding: ActivityCalendarBinding
    private lateinit var mAdapter: CalendarAdapter
    private var mCalendar = ArrayList<Calendar>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener(this)
        binding.calendarView.setOnDateChangeListener { _, i, i1, i2 ->
            year = i
            mouth = i1 + 1
            day = i2

        }

        setCalendarRv()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.backBtn -> {
                startActivity(Intent(this, Home::class.java))
                finish()
            }
        }
    }

    private fun setCalendarRv() {
        val recyclerViewCalendar = binding.recyclerViewCalendar
        recyclerViewCalendar.setHasFixedSize(true)
        recyclerViewCalendar.layoutManager = LinearLayoutManager(this)

        mAdapter = CalendarAdapter(mCalendar)
        recyclerViewCalendar.adapter = mAdapter

        addCalendarList()
    }

    private fun addCalendarList() {
        mCalendar.add(
            Calendar(
                "01", "OUT", "Dia das Crianças", "Feriado"

            )

        )
        mCalendar.add(
            Calendar(
                "01", "OUT", "Dia das Crianças", "Feriado"

            )

        )
        mCalendar.add(
            Calendar(
                "01", "OUT", "Dia das Crianças", "Feriado"

            )

        )
        mCalendar.add(
            Calendar(
                "01", "OUT", "Dia das Crianças", "Feriado"

            )

        )
        mCalendar.add(
            Calendar(
                "01", "OUT", "Dia das Crianças", "Feriado"

            )

        )
        mCalendar.add(
            Calendar(
                "01", "OUT", "Dia das Crianças", "Feriado"

            )

        )
        mCalendar.add(
            Calendar(
                "01", "OUT", "Dia das Crianças", "Feriado"

            )

        )
    }


}