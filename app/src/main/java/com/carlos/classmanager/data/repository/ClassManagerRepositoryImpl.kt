package com.carlos.classmanager.data.repository

import com.carlos.classmanager.data.remote.ClassManagerRepository
import com.carlos.classmanager.domain.model.ClassManager
import com.carlos.classmanager.domain.repository.ClassManagerApi
import javax.inject.Inject

class ClassManagerRepositoryImpl @Inject constructor(
    private val api: ClassManagerApi
) : ClassManagerRepository {
    override suspend fun getNoticesAndHomeWork(): List<ClassManager> {
        return api.getNoticesAndHomeWork()
    }
}