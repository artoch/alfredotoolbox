package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.network.repository.testdata.TestRepository
import com.tochapps.alfredotoolbox.data.network.repository.testdata.TestRepositoryImpl
import com.tochapps.alfredotoolbox.data.network.service.testdata.TestService
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