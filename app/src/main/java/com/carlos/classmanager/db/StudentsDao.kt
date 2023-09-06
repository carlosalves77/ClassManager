package com.carlos.classmanager.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.carlos.classmanager.model.Students
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(students: Students)

    @Query("SELECT * FROM students_table ORDER BY id ASC")
    fun getAllStudent(): Flow<List<Students>>

    @Query("DELETE FROM students_table WHERE id = :id")
    suspend fun deleteStudentById(id: Int)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateStudent(students: Students)

    @Query("SELECT * FROM students_table WHERE name LIKE :searchQuery")
    fun searchNameStudent(searchQuery: String): Flow<List<Students>>
}