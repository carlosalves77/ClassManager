package com.carlos.classmanager.model

data class Notices(
    val title: String,
    val logo: Int,
    val date: String,
    val description: String,
    val noticePicture: String? = null
)
