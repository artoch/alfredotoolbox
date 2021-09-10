package com.tochapps.practicetestapp.data.local.dao.testdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tochapps.practicetestapp.data.local.model.TestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Query("SELECT * FROM test_table")
    fun getAllLocalTest(): Flow<List<TestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTest(postItemEntity: TestEntity)

    @Query("DELETE FROM test_table WHERE :id = id")
    suspend fun deletePost(id:Int)

    @Query("SELECT * FROM test_table WHERE :id = id")
    suspend fun getPost(id:Int): TestEntity
}