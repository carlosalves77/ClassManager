package com.carlos.classmanager.model

data class Examination(

    val description: String,
    val id: Int? = null,
    val questionsList: List<Questions>
    )
