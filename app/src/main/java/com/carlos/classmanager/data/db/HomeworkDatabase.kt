package com.carlos.classmanager.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carlos.classmanager.domain.model.HomeWork

@Database(entities = [HomeWork::class], version = 1)
abstract class HomeworkDatabase : RoomDatabase() {
    abstract fun homeworkDao() : HomeworkDao

}


