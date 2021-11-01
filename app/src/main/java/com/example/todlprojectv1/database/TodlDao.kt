package com.example.todlprojectv1.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Delete




@Dao
interface TodlDao {
    @Insert
    suspend fun addList(todlModelList: TodlModelList)
    @Insert
    suspend fun addsubList(todlModesublList: TodlModelSubList)

    @Transaction
    @Query("SELECT * FROM todlmodellist")
    fun getList() : LiveData<List<MainTaskWithSubTask>>
    @Transaction
    @Query("SELECT * FROM todlmodelsublist WHERE mainTaskId = :taskId")
    fun getsubList(taskId:Int):LiveData<List<TodlModelSubList>>


    @Update
    suspend fun updateList(todlModelList: TodlModelList)
    @Update
    suspend fun updatesubList(todlModesublList: TodlModelSubList)

    @Delete
    suspend fun deleteList(todlModelList: TodlModelList )
    @Delete
    suspend fun deletesubList(todlModesublList: TodlModelSubList)



}