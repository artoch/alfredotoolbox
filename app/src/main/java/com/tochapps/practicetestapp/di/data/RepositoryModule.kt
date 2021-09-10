package com.tochapps.practicetestapp.di.data

import com.tochapps.practicetestapp.data.network.repository.testdata.TestRepository
import com.tochapps.practicetestapp.data.network.repository.testdata.TestRepositoryImpl
import com.tochapps.practicetestapp.data.network.service.testdata.TestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTestRepository(
        service: TestService
    ): TestRepository = TestRepositoryImpl(
        service
    )
}