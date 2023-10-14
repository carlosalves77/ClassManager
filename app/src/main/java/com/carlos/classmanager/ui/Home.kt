package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.adapter.HomeworkAdapter
import com.carlos.classmanager.adapter.NoticeAdapter
import com.carlos.classmanager.databinding.ActivityHomeBinding
import com.carlos.classmanager.model.HomeWork
import com.carlos.classmanager.model.Notices
import com.carlos.classmanager.utils.ListOfHomeWork
import com.carlos.classmanager.utils.ListOfNotices
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    private var mNotices = ArrayList<Notices>()
    private var mHomeWork = ArrayList<HomeWork>()

    private lateinit var adapterNotice: NoticeAdapter
    private lateinit var adapterHomeWork: HomeworkAdapter

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        @Suppress("DEPRECATION")
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.menuOption.setOnClickListener(this)
        auth = FirebaseAuth.getInstance()


        getAccountInfo()
        setNoticeRv()
        setHomeworkRv()

    }

    private fun getAccountInfo() {
        if (auth.currentUser != null) {
            val nameProfile = auth.currentUser?.displayName
            val profileUrl = auth.currentUser?.photoUrl
            binding.nameTeacherText.text = nameProfile
            Glide.with(this).load(profileUrl).into(binding.imgProfile)
        }
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.menuOption -> {
                showMenu()
            }
        }
    }

    private fun showMenu() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }

    private fun setNoticeRv() {
        val recyclerViewNotice = binding.noticeRv
        recyclerViewNotice.setHasFixedSize(true)
        recyclerViewNotice.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapterNotice = NoticeAdapter(mNotices)
        recyclerViewNotice.adapter = adapterNotice

        addNoticeList()
    }

    private fun setHomeworkRv() {

        val recyclerViewHomework = binding.homeWorkRv
        recyclerViewHomework.setHasFixedSize(true)
        recyclerViewHomework.layoutManager = LinearLayoutManager(this)


        adapterHomeWork = HomeworkAdapter(mHomeWork)
        recyclerViewHomework.adapter = adapterHomeWork


        addHomeworkList()
    }


    private fun addNoticeList() {
        val listOfNotices = ListOfNotices()
        mNotices.addAll(listOfNotices.listOfNotices)
    }

    private fun addHomeworkList() {

        val listOfHomeWork = ListOfHomeWork()

        mHomeWork.addAll(listOfHomeWork.homeWorkList)

    }

}