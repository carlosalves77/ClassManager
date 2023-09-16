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
        mNotices.add(
            Notices(
                "Dia das Profissões",
                R.drawable.logo,
                "07 outubro 2023",
                "Este evento convida profissionais de diversas áreas, como médicos, engenheiros, advogados, artistas e outros, para compartilhar suas experiências de carreira com os alunos. Os alunos têm a oportunidade de fazer perguntas, aprender sobre diferentes profissões e explorar possíveis caminhos para o futuro.",
                "https://i.ytimg.com/vi/wdB5mYdayl0/maxresdefault.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Feira de Ciências",
                R.drawable.logo,
                "14 outubro 2023",
                "A Feira de Ciências é uma oportunidade para os alunos mostrarem seus projetos científicos. Eles podem conduzir experimentos, criar modelos e apresentar suas descobertas para colegas, professores e até mesmo para pais e responsáveis. Competições podem ser organizadas para reconhecer o trabalho excepcional.",
                "https://i.pinimg.com/originals/e3/d3/89/e3d38938fa83e153323b7faabda8fe16.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Festival de Outono",
                R.drawable.logo,
                "02 outubro 2023",
                "Um evento temático de outono que celebra a estação. Pode incluir atividades como colheita de abóboras, pintura facial, concurso de esculturas de abóboras, venda de produtos típicos da estação e jogos ao ar livre, como corridas de saco e corridas de ovos.",
                "https://3.bp.blogspot.com/-W-kAvLRS8oQ/T4mK_UhyOkI/AAAAAAAAAUw/9sivXFd7nZA/s1600/DSCF3192.JPG"
            )
        )
        mNotices.add(
            Notices(
                "Semana da Saúde",
                R.drawable.logo,
                "10/14 outubro 2023",
                "Durante essa semana, a escola foca na promoção da saúde física e mental dos alunos. Isso pode incluir palestras sobre nutrição, exercícios, gerenciamento do estresse, além de atividades físicas como aulas de yoga ou caminhadas.",
                "https://www.ergocorp.com.br/uploads/images/bra_noticias/arte-post-800x445.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Noite das Artes",
                R.drawable.logo,
                "21 outubro 2023",
                "Um evento que destaca o talento artístico dos alunos. Pode incluir apresentações de peças de teatro, concertos musicais, exibições de dança e galerias de arte com trabalhos dos estudantes.",
                "https://static.todamateria.com.br/upload/no/it/noiteestreladasobrerodano-cke.jpg?auto_optimize=low"
            )
        )
        mNotices.add(
            Notices(
                "Semana da Leitura",
                R.drawable.logo,
                "17/21 outubro 2023",
                "Uma semana dedicada à promoção da leitura e da literacia. Os alunos podem participar de sessões de contos, clubes de leitura, concursos de redação e até mesmo troca de livros.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR7ZxvrBqCsDbARPoPyMR0d0QlEKvFhBMY-g&usqp=CAU"
            )
        )
        mNotices.add(
            Notices(
                "Dia da História",
                R.drawable.logo,
                "27 outubro 2023",
                "Um dia dedicado à exploração da história local, nacional ou global. Isso pode envolver palestras de historiadores, visitas a museus locais, apresentações de projetos de pesquisa dos alunos e até mesmo atividades de reencenação histórica.",
              "https://scontent.frec24-1.fna.fbcdn.net/v/t39.30808-6/360083055_799383858508904_1027747630006410263_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=52f669&_nc_eui2=AeGgL8iWN2IGb-Qu_UB6lyw9Yxtc5_kKRV9jG1zn-QpFX6PQki182Cdu4DZ5qtRYqjN-wZNX5vMgVcar1Fun1-Wq&_nc_ohc=N2RBfDaHnMQAX9_6Dit&_nc_ht=scontent.frec24-1.fna&oh=00_AfD6gUgK-Yhbv66-06n99fzmyFlWWSkQXoVgAbicCbjgCA&oe=650BB001"
            )
        )
        mNotices.add(
            Notices(
                "Feira de Carreiras",
                R.drawable.logo,
                "26 outubro 2023",
                "Este evento é voltado para alunos mais velhos que estão começando a pensar sobre seus futuros acadêmicos e profissionais. Faculdades e empresas locais montam estandes para apresentar suas ofertas e responder às perguntas dos alunos sobre oportunidades educacionais e de carreira.",
                "https://maraba.pa.gov.br/wp-content/uploads/2022/09/2022-08-31-FEIRA-DAS-PROFISSOES-FOTO-P-4.jpeg"

            )
        )
        mNotices.add(
            Notices(
                "Festival Internacional",
                R.drawable.logo,
                "28 outubro 2023",
                " Um evento que celebra a diversidade cultural da escola. Pode incluir estandes de comida com pratos típicos de diferentes países, apresentações de dança e música tradicional, exposições culturais e palestras sobre a importância da diversidade e inclusão.",
              "https://m.media-amazon.com/images/I/61jilk29tZL._AC_UF894,1000_QL80_.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Dia da Família",
                R.drawable.logo,
                "30 outubro 2023",
                "Um dia para envolver os pais e responsáveis na vida escolar de seus filhos. Pode incluir oficinas interativas, jogos em equipe que promovam a colaboração entre pais e filhos, além de sessões informativas sobre a educação dos filhos e recursos disponíveis na escola.",
               "https://www.cmac.es.gov.br/uploads/filemanager/noticias/Dia%20Interancional%20da%20Fam%C3%ADlia.png"
            )
        )
    }

    private fun addHomeworkList() {
        mHomeWork.add(HomeWork("Ensinar conteúdo curricular", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Avaliar o progresso dos alunos", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Dar feedback aos alunos", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Planejar atividades extracurriculares", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Participar de reuniões de equipe", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Desenvolver materiais didáticos", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Manter registros e documentação", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Comunicar-se com os pais", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Comunicar-se com os pais", "Data da Tarefa"))
        mHomeWork.add(HomeWork("Comunicar-se com os pais", "Data da Tarefa"))
    }

}