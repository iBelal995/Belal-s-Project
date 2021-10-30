package com.example.todlprojectv1.repository

import android.content.Context
import androidx.room.Room
import com.example.todlprojectv1.database.TodlDatabase
import com.example.todlprojectv1.database.TodlModelList
import com.example.todlprojectv1.database.TodlModelSubList
import java.lang.Exception

private const val DATABASE_NAME = "todl_database"
class TodlRepository(context:Context) {
    private val database: TodlDatabase =
        Room.databaseBuilder(
            context,
            TodlDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    private val todlDao = database.todlDao()

    // In turn, you can use the methods from the DAO instance to interact with the database:
    fun getList() = todlDao.getList()
    fun getsubList() = todlDao.getsubList()

    suspend fun addList(todlModelList:TodlModelList) = todlDao.addList(todlModelList)
    suspend fun updateList(todlModelList: TodlModelList) = todlDao.updateList(todlModelList)
    suspend fun deleteList(todlModelList: TodlModelList) = todlDao.deleteList(todlModelList)
    suspend fun addsubList(todlModesublList:TodlModelSubList) = todlDao.addsubList(todlModesublList)
    suspend fun updatesubList(todlModesublList: TodlModelSubList) = todlDao.updatesubList(todlModesublList)
    suspend fun deletesubList(todlModesublList: TodlModelSubList) = todlDao.deletesubList(todlModesublList)


    /***
     * this companion object for restricts the instantiation of a class to one "single" instance.
     * This is useful when exactly one object is needed to coordinate actions across the system.
     * */

    companion object {
        private var instance: TodlRepository? = null

        fun init(context: Context) {
            if (instance == null)
                instance = TodlRepository(context)
        }

        fun get(): TodlRepository {
            return instance ?: throw Exception("Todl Repository must be initialized")
        }
    }
}