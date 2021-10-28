package com.example.todlprojectv1.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodlModelList::class],version = 1)
abstract class TodlDatabase:RoomDatabase() {
    abstract fun todlDao():TodlDao
}