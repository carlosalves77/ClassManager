package com.carlos.classmanager.domain.model

import androidx.room.Entity

@Entity(tableName = "tasks_table")
data class Tasks(
    val taskTitle: String,
    val taskDate: String,
)
