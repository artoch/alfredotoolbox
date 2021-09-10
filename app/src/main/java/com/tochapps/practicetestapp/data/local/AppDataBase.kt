package com.tochapps.practicetestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tochapps.practicetestapp.data.local.dao.testdata.TestDao
import com.tochapps.practicetestapp.data.local.model.TestEntity

@Database(entities = [TestEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun  getTestDao(): TestDao
}