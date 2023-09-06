package com.carlos.classmanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_table")
data class Students(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id") val id: Int,

    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "Birthday") val birthday: String,
    @ColumnInfo(name = "Picture") val picture: String,
    @ColumnInfo(name = "Address") val address: String,
    @ColumnInfo(name = "Registration") val registration: String,
    @ColumnInfo(name = "StudentYear") val studentYear: String,
    @ColumnInfo(name = "Observation") val observation: String,
)
