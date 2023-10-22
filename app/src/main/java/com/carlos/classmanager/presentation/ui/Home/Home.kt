package com.carlos.classmanager.presentation.ui.Home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.cammon.utils.ListOfNotices
import com.carlos.classmanager.databinding.ActivityHomeBinding
import com.carlos.classmanager.domain.model.Notices
import com.carlos.classmanager.presentation.adapter.HomeworkAdapter
import com.carlos.classmanager.presentation.adapter.NoticeAdapter
import com.carlos.classmanager.presentation.ui.Homework.AddHomework
import com.carlos.classmanager.presentation.ui.Menu
import com.carlos.classmanager.presentation.viewModel.AddNoteViewModel
import com.carlos.classmanager.presentation.viewModel.HomeViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Home : AppCompatActivity(), View.OnClickListener {


//    private val homeViewModel : HomeViewModel by viewModels()
    private val mAddNoteViewModel : AddNoteViewModel by viewModels()

    private lateinit var binding: ActivityHomeBinding
    private var mNotices = ArrayList<Notices>()

    private lateinit var adapterNotice: NoticeAdapter

    private val adapterHomeWork =  HomeworkAdapter()

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuOption.setOnClickListener(this)
        auth = FirebaseAuth.getInstance()


        getAccountInfo()
        setNoticeRv()
        noticesShimmer()
        setHomeworkRv()

        binding.fabBtn.setOnClickListener(this)

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
            R.id.fabBtn -> {
                addHomework()

            }
        }
    }

    private fun showMenu() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }

    private fun addHomework() {
        startActivity(Intent(this, AddHomework::class.java ))
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
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



    private fun noticesShimmer() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.noticiesShimmer.visibility = View.GONE
            binding.noticeContentShimmer.visibility = View.GONE
            binding.noticeRv.visibility = View.VISIBLE
        }, 3000)
    }


    private fun setHomeworkRv() {

        val recyclerViewHomework = binding.homeWorkRv
        recyclerViewHomework.setHasFixedSize(true)
        recyclerViewHomework.layoutManager = LinearLayoutManager(this)
        recyclerViewHomework.adapter = adapterHomeWork

        lifecycleScope.launch {
            mAddNoteViewModel.getAllHomework.collect { data ->
                adapterHomeWork.setData(data)
             if (data.isEmpty()) {
                 binding.emptyHomework.visibility = View.VISIBLE
             } else {
                 binding.emptyHomework.visibility = View.GONE
                 binding.homeWorkRv.visibility = View.VISIBLE
             }
            }
        }


    }

    private fun addNoticeList() {
        val listOfNotices = ListOfNotices()
        mNotices.addAll(listOfNotices.listOfNotices)
    }

}