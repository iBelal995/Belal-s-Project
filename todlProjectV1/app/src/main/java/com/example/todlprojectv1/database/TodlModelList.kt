package com.example.todlprojectv1.database

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodlModelList (
    val taskTitle:String,
    val taskSubTitle:String,
    val priority:RadioGroup,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    )
