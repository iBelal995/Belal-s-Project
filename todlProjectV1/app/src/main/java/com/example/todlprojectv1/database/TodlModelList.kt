package com.example.todlprojectv1.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class TodlModelList(
    val taskTitle:String,
    val priority: String,
    var dueDate: Long?,
    var completed: Boolean,
    @PrimaryKey(autoGenerate = true)
    val taskId: Int =0
    )
@Entity
data class TodlModelSubList(
    val subTask:String,
    val description:String,
    val prioritysub : String,
    var creationDate: Long,
    val mainTaskId:Int,
    @PrimaryKey(autoGenerate = true)
    val subTaskId: Int = 0
)
data class MainTaskWithSubTask(
    @Embedded val task: TodlModelList,
    @Relation(
        parentColumn = "taskId",
        entityColumn = "mainTaskId"
    )
    val subTask: TodlModelSubList?
)