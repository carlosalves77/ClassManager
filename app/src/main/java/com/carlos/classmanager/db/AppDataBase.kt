package com.carlos.classmanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carlos.classmanager.model.Students

@Database(entities = [Students::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun studentDao() : StudentsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "students_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}