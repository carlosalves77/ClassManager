package com.carlos.classmanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import com.carlos.classmanager.R
import com.carlos.classmanager.databinding.ActivityCalendarBinding

class Calendar : AppCompatActivity() {

    private var year: Int = 0
    private var mouth: Int = 0
    private var day: Int = 0

    private var total: Int = 0

   private lateinit var binding: ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

      binding.calendarView.setOnDateChangeListener {
              _, i, i1, i2 ->
          year = i
          mouth = i1 + 1
          day = i2

      }
    }
}