package com.tochapps.alfredotoolbox.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tochapps.alfredotoolbox.data.local.dao.tokendata.TokenDao
import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity

@Database(entities = [TokenRoomEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun  getTestDao(): TokenDao
}