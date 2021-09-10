package com.tochapps.practicetestapp.di.data

import com.tochapps.practicetestapp.data.network.service.testdata.TestService
import com.tochapps.practicetestapp.data.network.service.testdata.TestServiceImpl
import com.tochapps.practicetestapp.di.KtorModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object ServiceModule {

    @Singleton
    @Provides
    fun provideTestService(
        httpClient: HttpClient,
        @Named(KtorModule.BASE_URL_KEY) baseUrl: String,
    ): TestService = TestServiceImpl(
        httpClient = httpClient,
        baseUrl = baseUrl,
    )
}