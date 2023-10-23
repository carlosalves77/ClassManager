package com.carlos.classmanager.di

import android.content.Context
import androidx.room.Room
import com.carlos.classmanager.data.db.HomeworkDao
import com.carlos.classmanager.data.db.HomeworkDatabase
import com.carlos.classmanager.domain.repository.HomeworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        HomeworkDatabase::class.java,
        "homework_database"
    ).build()

    @Provides
    fun provideHomeWorkRepository(homework: HomeworkDao): HomeworkRepository =
        HomeworkRepository(homework)

    @Provides
    fun provideHomeworkDao(db: HomeworkDatabase): HomeworkDao = db.homeworkDao()

}