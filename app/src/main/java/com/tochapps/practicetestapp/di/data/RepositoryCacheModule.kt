package com.tochapps.practicetestapp.di.data

import com.tochapps.practicetestapp.data.local.dao.testdata.TestDao
import com.tochapps.practicetestapp.data.local.repository.testdata.TestCacheRepository
import com.tochapps.practicetestapp.data.local.repository.testdata.TestCacheRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object RepositoryCacheModule {
    @Singleton
    @Provides
    fun provideTestRepository(
        dao: TestDao
    ): TestCacheRepository = TestCacheRepositoryImpl(
        dao
    )
}