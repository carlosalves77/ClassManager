package com.carlos.classmanager.data.remote

import com.carlos.classmanager.domain.model.ClassManager

interface ClassManagerRepository {
    suspend fun getNoticesAndHomeWork() : List<ClassManager>
}