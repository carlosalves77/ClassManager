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
                "https://i.ytimg.com/vi/wdB5mYdayl0/maxresdefault.jpg",
                "07 outubro 2023",
                "O \"Dia das Profissões\" é um evento ou atividade que visa proporcionar aos estudantes a oportunidade de aprender sobre várias profissões, explorar diferentes carreiras e obter informações valiosas sobre escolhas de carreira futura. Esse dia geralmente ocorre em escolas, universidades ou eventos educacionais e pode incluir uma variedade de atividades, como palestras, workshops, feiras de carreiras, visitas a empresas e painéis de discussão.\n" +
                        "\n" +
                        "O objetivo principal do Dia das Profissões é ajudar os estudantes a tomar decisões informadas sobre seus futuros acadêmicos e profissionais, permitindo que eles conheçam de perto profissionais de diferentes áreas e entendam melhor as demandas, responsabilidades e oportunidades de diversas profissões. Isso pode ser especialmente valioso para estudantes do ensino médio que estão prestes a ingressar na faculdade ou escolher uma carreira.\n" +
                        "\n" +
                        "Em resumo, o Dia das Profissões é uma iniciativa educacional que visa orientar os estudantes em suas escolhas de carreira, oferecendo informações e experiências práticas relacionadas a várias profissões.",
                "https://i.ytimg.com/vi/wdB5mYdayl0/maxresdefault.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Feira de Ciências",
                "https://i.pinimg.com/originals/e3/d3/89/e3d38938fa83e153323b7faabda8fe16.jpg",
                "14 outubro 2023",
                "Uma Feira de Ciências é um evento educacional que reúne estudantes, professores e, às vezes, até mesmo membros da comunidade para apresentar projetos e experimentos relacionados a diversas áreas da ciência. Esses eventos têm como objetivo principal promover o aprendizado prático da ciência, estimular o interesse por disciplinas científicas e incentivar a criatividade e a pesquisa.\n" +
                        "\n" +
                        "Em uma Feira de Ciências, os participantes geralmente criam projetos que incluem hipóteses, experimentos, coleta de dados e análise dos resultados. Eles apresentam seus projetos em estandes ou exposições, onde podem compartilhar seus conhecimentos com os visitantes e, muitas vezes, são avaliados por um painel de jurados. As feiras de ciências são uma oportunidade para os estudantes desenvolverem habilidades de comunicação, aprenderem a metodologia científica e se envolverem ativamente na exploração do mundo ao seu redor.\n" +
                        "\n" +
                        "Esses eventos são uma parte importante da educação científica e promovem a curiosidade e o pensamento crítico entre os participantes, ajudando a criar uma base sólida para futuros estudos e carreiras nas áreas de ciência, tecnologia, engenharia e matemática",
                "https://i.pinimg.com/originals/e3/d3/89/e3d38938fa83e153323b7faabda8fe16.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Festival de Outono",
                "02 outubro 2023",
                "O Festival de Outono é uma celebração sazonal que ocorre em muitas culturas ao redor do mundo durante a estação do outono. É uma festividade que marca a colheita, expressa a gratidão pela abundância de alimentos e comemora a transição do calor do verão para o frio do inverno.\n" +
                        "\n" +
                        "Neste festival, as pessoas se envolvem em atividades tradicionais que variam de cultura para cultura. Isso pode incluir a preparação de pratos sazonais, a realização de festas comunitárias, desfiles e decoração de espaços com temas outonais, como abóboras, folhas secas e outros elementos naturais típicos da estação.\n" +
                        "\n" +
                        "Uma característica comum em muitos festivais de outono é a ênfase na gratidão. As pessoas expressam sua apreciação pelas colheitas bem-sucedidas, pela comida que têm à mesa e pelas bênçãos que receberam durante o ano. Isso é frequentemente feito por meio de orações, rituais ou banquetes compartilhados com familiares e amigos.",
                "Um evento temático de outono que celebra a estação. Pode incluir atividades como colheita de abóboras, pintura facial, concurso de esculturas de abóboras, venda de produtos típicos da estação e jogos ao ar livre, como corridas de saco e corridas de ovos.",
                "https://3.bp.blogspot.com/-W-kAvLRS8oQ/T4mK_UhyOkI/AAAAAAAAAUw/9sivXFd7nZA/s1600/DSCF3192.JPG"
            )
        )
        //TODO = Refactor description

        mNotices.add(
            Notices(
                "Semana da Saúde",
                "https://www.ergocorp.com.br/uploads/images/bra_noticias/arte-post-800x445.jpg",
                "10/14 outubro 2023",
                "Durante essa semana, a escola foca na promoção da saúde física e mental dos alunos. Isso pode incluir palestras sobre nutrição, exercícios, gerenciamento do estresse, além de atividades físicas como aulas de yoga ou caminhadas.",
                "https://www.ergocorp.com.br/uploads/images/bra_noticias/arte-post-800x445.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Noite das Artes",
                "https://static.todamateria.com.br/upload/no/it/noiteestreladasobrerodano-cke.jpg?auto_optimize=low",
                "21 outubro 2023",
                "Um evento que destaca o talento artístico dos alunos. Pode incluir apresentações de peças de teatro, concertos musicais, exibições de dança e galerias de arte com trabalhos dos estudantes.",
                "https://static.todamateria.com.br/upload/no/it/noiteestreladasobrerodano-cke.jpg?auto_optimize=low"
            )
        )
        mNotices.add(
            Notices(
                "Semana da Leitura",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR7ZxvrBqCsDbARPoPyMR0d0QlEKvFhBMY-g&usqp=CAU",
                "17/21 outubro 2023",
                "Uma semana dedicada à promoção da leitura e da literacia. Os alunos podem participar de sessões de contos, clubes de leitura, concursos de redação e até mesmo troca de livros.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR7ZxvrBqCsDbARPoPyMR0d0QlEKvFhBMY-g&usqp=CAU",
            )
        )
        mNotices.add(
            Notices(
                "Dia da História",
                "https://i0.wp.com/eumilitar.blog/wp-content/uploads/2020/09/D-PEDRO.jpg?fit=1200%2C1200&ssl=1",
                "27 outubro 2023",
                "Um dia dedicado à exploração da história local, nacional ou global. Isso pode envolver palestras de historiadores, visitas a museus locais, apresentações de projetos de pesquisa dos alunos e até mesmo atividades de reencenação histórica.",
                "https://i0.wp.com/eumilitar.blog/wp-content/uploads/2020/09/D-PEDRO.jpg?fit=1200%2C1200&ssl=1"
                )
        )
        mNotices.add(
            Notices(
                "Feira de Carreiras",
                "https://maraba.pa.gov.br/wp-content/uploads/2022/09/2022-08-31-FEIRA-DAS-PROFISSOES-FOTO-P-4.jpeg",
                "26 outubro 2023",
                "Este evento é voltado para alunos mais velhos que estão começando a pensar sobre seus futuros acadêmicos e profissionais. Faculdades e empresas locais montam estandes para apresentar suas ofertas e responder às perguntas dos alunos sobre oportunidades educacionais e de carreira.",
                "https://maraba.pa.gov.br/wp-content/uploads/2022/09/2022-08-31-FEIRA-DAS-PROFISSOES-FOTO-P-4.jpeg"

            )
        )
        mNotices.add(
            Notices(
                "Festival Internacional",
                "https://m.media-amazon.com/images/I/61jilk29tZL._AC_UF894,1000_QL80_.jpg",
                "28 outubro 2023",
                " Um evento que celebra a diversidade cultural da escola. Pode incluir estandes de comida com pratos típicos de diferentes países, apresentações de dança e música tradicional, exposições culturais e palestras sobre a importância da diversidade e inclusão.",
              "https://m.media-amazon.com/images/I/61jilk29tZL._AC_UF894,1000_QL80_.jpg"
            )
        )
        mNotices.add(
            Notices(
                "Dia da Família",
                "https://www.cmac.es.gov.br/uploads/filemanager/noticias/Dia%20Interancional%20da%20Fam%C3%ADlia.png",
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