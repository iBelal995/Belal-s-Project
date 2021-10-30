package com.example.todlprojectv1.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodlDao {
    @Insert
    suspend fun addList(todlModelList: TodlModelList)
    suspend fun addList(todlModesublList: TodlModelSubList)

    @Transaction
    @Query("SELECT * FROM todlmodellist,todlmodelsublist")
    fun getList() : LiveData<List<MainTaskWithSubTask>>


    @Update
    suspend fun updateList(todlModelList: TodlModelList)
    suspend fun updateList(todlModesublList: TodlModelSubList)


    @Delete
    suspend fun deleteList(todlModelList: TodlModelList)
    suspend fun deleteList(todlModesublList: TodlModelSubList)
}