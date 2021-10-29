package com.example.todlprojectv1.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodlModelList(
    val taskTitle:String,
    val taskSubTitle:String,
    val priority: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    )
