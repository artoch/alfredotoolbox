package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.network.repository.toolboxdata.ToolBoxRepository
import com.tochapps.alfredotoolbox.data.network.repository.toolboxdata.ToolBoxRepositoryImpl
import com.tochapps.alfredotoolbox.data.network.service.toolboxservice.ToolBoxService
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
}