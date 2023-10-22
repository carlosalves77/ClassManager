package com.carlos.classmanager.presentation.State

import com.carlos.classmanager.domain.model.ClassManager

data class HomeworkAndNoticeList(

    val isLoading: Boolean = false,
    val homeworkAndNotice: List<ClassManager> = emptyList(),
    val error: String = ""

)

