package com.carlos.classmanager.domain.model

data class Examination(

    val description: String,
    val id: Int? = null,
    val questionsList: List<Questions>
    )
