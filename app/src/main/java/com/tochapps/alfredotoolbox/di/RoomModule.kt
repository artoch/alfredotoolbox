package com.tochapps.alfredotoolbox.di

import android.content.Context
import androidx.room.Room
import com.tochapps.alfredotoolbox.common.DATABASE_NAME
import com.tochapps.alfredotoolbox.data.local.AppDataBase
import com.tochapps.alfredotoolbox.data.local.dao.testdata.TestDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object RoomModule {
    @Singleton
    @Provides
    fun appDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun postDao(appDatabase: AppDataBase): TestDao {
        return appDatabase.getTestDao()
    }
}