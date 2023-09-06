package com.carlos.classmanager.repositories

import com.carlos.classmanager.db.StudentsDao
import com.carlos.classmanager.model.Students
import kotlinx.coroutines.flow.Flow

class StudentsRepository(private val studentsDao: StudentsDao) {

    suspend fun insertStudent(students: Students) {
        studentsDao.insertStudent(students)
    }

    fun getAllStudents(): Flow<List<Students>> = studentsDao.getAllStudent()

    suspend fun updateStudent(students: Students) {
        studentsDao.updateStudent(students)
    }

    fun searchStudents(searchQuery: String): Flow<List<Students>> = studentsDao.searchNameStudent(searchQuery)
}