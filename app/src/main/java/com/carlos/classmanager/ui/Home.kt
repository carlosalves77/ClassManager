package com.carlos.classmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.classmanager.R
import com.carlos.classmanager.adapter.HomeworkAdapter
import com.carlos.classmanager.adapter.NoticeAdapter
import com.carlos.classmanager.databinding.ActivityHomeBinding
import com.carlos.classmanager.model.HomeWork
import com.carlos.classmanager.model.Notices

class Home : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    private var mNotices = ArrayList<Notices>()
    private var mHomeWork = ArrayList<HomeWork>()

    private lateinit var adapterNotice: NoticeAdapter
    private lateinit var adapterHomeWork: HomeworkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        @Suppress("DEPRECATION")
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.menuOption.setOnClickListener(this)

        setNoticeRv()
        setHomeworkRv()

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
        mNotices.add(
            Notices(
                "A escola entrará de férias no próximo mês",
                R.drawable.logo,
                "02 Outubro 2023"
            )
        )
        mNotices.add(
            Notices(
                "A escola entrará de férias no próximo mês",
                R.drawable.logo,
                "02 Outubro 2023"
            )
        )
        mNotices.add(
            Notices(
                "A escola entrará de férias no próximo mês",
                R.drawable.logo,
                "02 Outubro 2023"
            )
        )
        mNotices.add(
            Notices(
                "A escola entrará de férias no próximo mês",
                R.drawable.logo,
                "02 Outubro 2023"
            )
        )
        mNotices.add(
            Notices(
                "A escola entrará de férias no próximo mês",
                R.drawable.logo,
                "02 Outubro 2023"
            )
        )
        mNotices.add(
            Notices(
                "A escola entrará de férias no próximo mês",
                R.drawable.logo,
                "02 Outubro 2023"
            )
        )
    }

    private fun addHomeworkList() {
//        mHomeWork.add(HomeWork("Preparar planos de aula", "Hoje / 09.10.2023"))
//        mHomeWork.add(HomeWork("Preparar planos de aula", "Hoje / 09.10.2023"))
//        mHomeWork.add(HomeWork("Preparar planos de aula", "Hoje / 09.10.2023"))
//        mHomeWork.add(HomeWork("Preparar planos de aula", "Hoje / 09.10.2023"))
//        mHomeWork.add(HomeWork("Preparar planos de aula", "Hoje / 09.10.2023"))
//        mHomeWork.add(HomeWork("Preparar planos de aula", "Hoje / 09.10.2023"))
        mHomeWork.add(HomeWork("Ensinar conteúdo curricular", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Avaliar o progresso dos alunos", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Dar feedback aos alunos", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Planejar atividades extracurriculares", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Participar de reuniões de equipe", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Desenvolver materiais didáticos", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Manter registros e documentação", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Comunicar-se com os pais", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Aconselhar os alunos", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Participar de desenvolvimento profissional", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Lidar com comportamento e disciplina", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Promover um ambiente de aprendizado positivo", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Colaborar com os pais e a comunidade", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Acompanhar o desenvolvimento profissional", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Incentivar a criatividade", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Acompanhar as tendências educacionais", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Ajudar os alunos com necessidades especiais", "Data da Tarefa"))


    }


}