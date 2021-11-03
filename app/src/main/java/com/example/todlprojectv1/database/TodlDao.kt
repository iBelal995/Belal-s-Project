package com.example.todlprojectv1.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Delete



/**
* The following code defines a DAO called InventoryDao.
* InventoryDao provides the methods that the rest of the app uses to interact with data in the ItemModel table.
* */
@Dao
interface TodlDao {
    // The @Insert annotation allows you to define methods that insert their parameters into the appropriate table in the database
    @Insert
    suspend fun addList(todlModelList: TodlModelList)
    @Insert
    suspend fun addsubList(todlModesublList: TodlModelSubList)
    /**add a method to the DAO class that returns all instances of the data class that pairs the parent entity and the child entity. This method requires Room to run two queries,
     *

    so add the @Transaction annotation to this method to ensure that the whole operation is performed atomically.*/
    @Transaction
    /***
     * The @Query annotation allows you to write SQL statements and expose them as DAO methods.
     * Use these query methods to query data from your app's database,
     * or when you need to perform more complex inserts, updates, and deletes.
     *
     * Room validates SQL queries at compile time. This means that if there's a problem with your query,
     * a compilation error occurs instead of a runtime failure.
     * */
    @Query("SELECT * FROM todlmodellist")
    fun getList() : LiveData<List<MainTaskWithSubTask>>


    @Query("SELECT * FROM todlmodelsublist WHERE mainTaskId = :taskId")
    fun getsubList(taskId:Int):LiveData<List<TodlModelSubList>>

    // The @Update annotation allows you to define methods that update specific rows in a database table.
    // Similarly to @Insert methods, @Update methods accept data entity instances as parameters.
    @Update
    suspend fun updateList(todlModelList: TodlModelList)
    @Update
    suspend fun updatesubList(todlModesublList: TodlModelSubList)

    // The @Delete annotation allows you to define methods that delete specific rows from a database table.
    // Similarly to @Insert methods, @Delete methods accept data entity instances as parameters.
    @Delete
    suspend fun deleteList(todlModelList: TodlModelList )
    @Delete
    suspend fun deletesubList(todlModesublList: TodlModelSubList)



}