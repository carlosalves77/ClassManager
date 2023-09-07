package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.adapter.NoticeAdapter
import com.carlos.classmanager.databinding.ActivityHomeBinding
import com.carlos.classmanager.model.Notices

class Home : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    private var mNotices = ArrayList<Notices>()
    private lateinit var adapter: NoticeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        @Suppress("DEPRECATION")
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.menuOption.setOnClickListener(this)

        setNoticeRv()

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.menuOption -> {
                showMenu()
            }
        }
    }

    private fun showMenu() {
        startActivity(Intent(this, Menu::class.java))

    }

    private fun setNoticeRv() {
       val recyclerViewNotice = binding.noticeRv
        recyclerViewNotice.setHasFixedSize(true)
        recyclerViewNotice.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter = NoticeAdapter(mNotices)
        recyclerViewNotice.adapter = adapter

        addNoticeList()
    }

    private fun addNoticeList() {
        mNotices.add(Notices("A escola entrará de férias no próximo mês", R.drawable.logo, "02 Outubro 2023"))
        mNotices.add(Notices("A escola entrará de férias no próximo mês", R.drawable.logo, "02 Outubro 2023"))
        mNotices.add(Notices("A escola entrará de férias no próximo mês", R.drawable.logo, "02 Outubro 2023"))
        mNotices.add(Notices("A escola entrará de férias no próximo mês", R.drawable.logo, "02 Outubro 2023"))
    }


}