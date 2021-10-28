package com.example.todlprojectv1.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodlDao {
    @Insert
    suspend fun addList(todlModelList: TodlModelList)


    @Query("SELECT * FROM todlmodellist")
    fun getList() : LiveData<List<TodlModelList>>


    @Update
    suspend fun updateList(todlModelList: TodlModelList)


    @Delete
    suspend fun deleteList(todlModelList: TodlModelList)
}