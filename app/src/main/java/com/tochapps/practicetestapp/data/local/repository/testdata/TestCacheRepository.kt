package com.tochapps.practicetestapp.data.local.repository.testdata


import com.tochapps.practicetestapp.data.local.model.TestEntity
import kotlinx.coroutines.flow.Flow


interface TestCacheRepository  {

    fun getAllLocalTest(): Flow<List<TestEntity>>

    suspend fun addTest(postItemEntity: TestEntity)

    suspend fun deletePost(id:Int)

    suspend fun getPost(id:Int): TestEntity

}