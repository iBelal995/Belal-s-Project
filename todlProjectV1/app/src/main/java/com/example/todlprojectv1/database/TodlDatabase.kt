package com.example.todlprojectv1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TodlModelList::class,TodlModelSubList::class],version = 13)


abstract class TodlDatabase:RoomDatabase() {
    abstract fun todlDao():TodlDao
}