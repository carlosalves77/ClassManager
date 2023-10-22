package com.carlos.classmanager.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.carlos.classmanager.domain.model.HomeWork
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeworkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHomeWork(homeWork: HomeWork)

    @Query("SELECT * FROM student_homework ORDER BY id ASC")
    fun getAllHomeWork(): Flow<List<HomeWork>>

    @Query("DELETE FROM student_homework WHERE id = :id")
    suspend fun deleteStudentById(id: Int)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateHomework(homeWork: HomeWork)


}