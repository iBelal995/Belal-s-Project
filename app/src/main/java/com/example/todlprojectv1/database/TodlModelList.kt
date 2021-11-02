package com.example.todlprojectv1.database

import androidx.room.*

@Entity
data class TodlModelList(
    var taskTitle:String,
    val priority: String,
    var dueDate: String,
    var creationDate: Long,
    var completed: Boolean,
    @PrimaryKey(autoGenerate = true)
    val taskId: Int =0)
    @Entity(
foreignKeys = [ForeignKey(
    entity = TodlModelList::class,
    parentColumns = arrayOf("taskId"),
    childColumns = arrayOf("mainTaskId"),
    onDelete = ForeignKey.CASCADE
)]
)


    data class TodlModelSubList(
    val subTask:String,
    val prioritysub:String,
    var description:String,
    @ColumnInfo(index= true)
    val mainTaskId: Int,
    @PrimaryKey(autoGenerate = true)
    val subTaskId: Int = 0

)
data class MainTaskWithSubTask(
    @Embedded val task: TodlModelList,
    @Relation(
        parentColumn = "taskId",
        entityColumn = "mainTaskId"
    )
    val subTask: List<TodlModelSubList>
)


