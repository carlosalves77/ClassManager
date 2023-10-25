package com.carlos.classmanager.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_homework")
data class HomeWork(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id") val id: Int,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "DescriptionText") val descriptionText: String,
    @ColumnInfo(name = "Date") val date: String? = null,
)
