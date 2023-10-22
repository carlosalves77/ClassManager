package com.carlos.classmanager.domain.repository

import com.carlos.classmanager.domain.model.ClassManager
import retrofit2.http.GET

interface ClassManagerApi {

    @GET("/db")
    suspend fun getNoticesAndHomeWork() : List<ClassManager>

}