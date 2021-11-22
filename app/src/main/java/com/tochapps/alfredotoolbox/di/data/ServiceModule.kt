package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.network.model.BodyLogin
import com.tochapps.alfredotoolbox.data.network.service.toolboxservice.ToolBoxService
import com.tochapps.alfredotoolbox.data.network.service.toolboxservice.ToolBoxServiceImpl
import com.tochapps.alfredotoolbox.di.KtorModule
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
    fun provideLoginService(
        httpClient: HttpClient,
        @Named(KtorModule.BASE_URL_KEY) baseUrl: String
    ): ToolBoxService = ToolBoxServiceImpl(
        httpClient = httpClient,
        baseUrl = baseUrl
    )
}