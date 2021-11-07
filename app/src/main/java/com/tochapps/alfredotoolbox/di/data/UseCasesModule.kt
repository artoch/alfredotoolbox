package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.network.repository.testdata.TestRepository
import com.tochapps.alfredotoolbox.data.use_cases.test.TestUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object UseCasesModule {

    @Singleton
    @Provides
    fun provideTestUseCase(
        repository: TestRepository
    ): TestUseCase = TestUseCase(repository)
}