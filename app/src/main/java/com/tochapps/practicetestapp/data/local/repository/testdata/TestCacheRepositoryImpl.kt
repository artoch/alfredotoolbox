package com.tochapps.practicetestapp.data.local.repository.testdata

import com.tochapps.practicetestapp.data.local.dao.testdata.TestDao
import com.tochapps.practicetestapp.data.local.model.TestEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestCacheRepositoryImpl @Inject constructor(
    private val testDao: TestDao
):TestCacheRepository {

    override fun getAllLocalTest(): Flow<List<TestEntity>> = testDao.getAllLocalTest()

    override suspend fun addTest(postItemEntity: TestEntity) {
        testDao.addTest(postItemEntity)
    }

    override suspend fun deletePost(id: Int) {
        testDao.deletePost(id)
    }

    override suspend fun getPost(id: Int): TestEntity = testDao.getPost(id)

}