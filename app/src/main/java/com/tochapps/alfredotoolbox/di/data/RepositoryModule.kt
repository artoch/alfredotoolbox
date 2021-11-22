package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.network.repository.toolboxRetro.ToolBoxRepositoryRetro
import com.tochapps.alfredotoolbox.data.network.repository.toolboxRetro.ToolBoxRepositoryRetroImpl
import com.tochapps.alfredotoolbox.data.network.repository.toolboxdata.ToolBoxRepository
import com.tochapps.alfredotoolbox.data.network.repository.toolboxdata.ToolBoxRepositoryImpl
import com.tochapps.alfredotoolbox.data.network.service.toolboxservice.ToolBoxService
import com.tochapps.alfredotoolbox.data.retrofitNetwork.api.ApiService
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
    fun provideToolBoxRepository(
        service: ToolBoxService
    ): ToolBoxRepository = ToolBoxRepositoryImpl(
        service
    )

    @Singleton
    @Provides
    fun provideToolBoxRepositoryRetro(
        service: ApiService
    ): ToolBoxRepositoryRetro = ToolBoxRepositoryRetroImpl(
        service
    )
}