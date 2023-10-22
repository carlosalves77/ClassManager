package com.carlos.classmanager.domain.repository

import com.carlos.classmanager.data.db.HomeworkDao
import com.carlos.classmanager.domain.model.HomeWork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeworkRepository @Inject constructor(
    private val homeworkDao: HomeworkDao
) {

    suspend fun insertHomework(homeWork: HomeWork) {
        homeworkDao.insertHomeWork(homeWork)
    }

    fun getAllStudentsHomeWork(): Flow<List<HomeWork>> = homeworkDao.getAllHomeWork()

    suspend fun updateHomeWork(students: HomeWork) {
        homeworkDao.updateHomework(students)
    }

    suspend fun deleteHomeworkById(homeworkId: Int) {
        homeworkDao.deleteStudentById(homeworkId)
    }

}