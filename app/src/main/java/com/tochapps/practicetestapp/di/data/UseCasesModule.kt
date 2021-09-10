package com.tochapps.practicetestapp.di.data

import com.tochapps.practicetestapp.data.network.repository.testdata.TestRepository
import com.tochapps.practicetestapp.data.use_cases.test.TestUseCase
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