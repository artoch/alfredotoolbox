package com.tochapps.practicetestapp.di.data

import com.tochapps.practicetestapp.data.local.repository.testdata.TestCacheRepository
import com.tochapps.practicetestapp.data.local.use_case.AddTestCacheUC
import com.tochapps.practicetestapp.data.local.use_case.DeleteTestCacheUC
import com.tochapps.practicetestapp.data.local.use_case.GetTestCacheUC
import com.tochapps.practicetestapp.data.local.use_case.ListTestCacheUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object CacheUseCase {

    @Singleton
    @Provides
    fun provideGetTestCacheUseCase(
        dao: TestCacheRepository
    ): GetTestCacheUC = GetTestCacheUC(dao)

    @Singleton
    @Provides
    fun provideListTestCacheUseCase(
        dao: TestCacheRepository
    ): ListTestCacheUC = ListTestCacheUC(dao)

    @Singleton
    @Provides
    fun provideDeleteTestCacheUseCase(
        dao: TestCacheRepository
    ): DeleteTestCacheUC = DeleteTestCacheUC(dao)

    @Singleton
    @Provides
    fun provideAddTestCacheUseCase(
        dao: TestCacheRepository
    ): AddTestCacheUC = AddTestCacheUC(dao)
}