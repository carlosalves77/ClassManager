package com.carlos.classmanager.presentation.ui.Home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.classmanager.R
import com.carlos.classmanager.cammon.utils.HomeworkIdSingleton
import com.carlos.classmanager.cammon.utils.ListOfNotices
import com.carlos.classmanager.databinding.ActivityHomeBinding
import com.carlos.classmanager.domain.model.Notices
import com.carlos.classmanager.presentation.adapter.HomeworkAdapter
import com.carlos.classmanager.presentation.adapter.NoticeAdapter
import com.carlos.classmanager.presentation.adapter.SwipeGesture
import com.carlos.classmanager.presentation.ui.Homework.AddHomework
import com.carlos.classmanager.presentation.ui.Homework.EditNote
import com.carlos.classmanager.presentation.ui.Menu.Menu
import com.carlos.classmanager.presentation.viewModel.AddNoteViewModel
import com.carlos.classmanager.presentation.viewModel.HomeViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Home : AppCompatActivity(), View.OnClickListener {

    private val mAddNoteViewModel: AddNoteViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityHomeBinding
    private var mNotices = ArrayList<Notices>()

    private lateinit var adapterNotice: NoticeAdapter

    private val adapterHomeWork = HomeworkAdapter()

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


        CoroutineScope(Dispatchers.IO).launch {
            homeViewModel.state.collect { data ->
                Log.i("MyDataResponse", "$data")
            }
        }


        deleteUser()
    }

    private fun deleteUser() {

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
        startActivity(Intent(this, AddHomework::class.java))
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun setNoticeRv() {
        val recyclerViewNotice = binding.noticeRv
        recyclerViewNotice.setHasFixedSize(true)
        recyclerViewNotice.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapterNotice = NoticeAdapter(mNotices, binding)
        recyclerViewNotice.adapter = adapterNotice

        addNoticeList()
    }


    private fun noticesShimmer() {

        binding.noticiesShimmer.visibility = View.GONE
        binding.noticeContentShimmer.visibility = View.GONE
        binding.noticeRv.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
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

        val swipegesture = object : SwipeGesture(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        lifecycleScope.launch {
                            mAddNoteViewModel.deleteNote(HomeworkIdSingleton.homeworkId)
                        }
                    }

                    ItemTouchHelper.RIGHT -> {
                        val intent = Intent(this@Home, EditNote::class.java)
                        intent.putExtra("title", HomeworkIdSingleton.title)
                        intent.putExtra("date", HomeworkIdSingleton.dateHomework)
                        intent.putExtra("titleDescription", HomeworkIdSingleton.titleDescription)
                        startActivity(intent)
                    }
                }

            }
        }

        val touchHelper = ItemTouchHelper(swipegesture)
        touchHelper.attachToRecyclerView(recyclerViewHomework)


    }

    private fun addNoticeList() {
        val listOfNotices = ListOfNotices()
        mNotices.addAll(listOfNotices.listOfNotices)
    }

}