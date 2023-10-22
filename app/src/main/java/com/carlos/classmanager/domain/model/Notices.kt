package com.carlos.classmanager.domain.model

import android.net.Uri

data class Notices(
    val title: String,
    val logo: String,
    val date: String,
    val description: String,
    val noticePicture: String? = null
)
