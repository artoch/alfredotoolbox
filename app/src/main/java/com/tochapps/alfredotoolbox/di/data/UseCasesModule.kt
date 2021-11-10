package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.local.use_case.AddTokenUC
import com.tochapps.alfredotoolbox.data.local.use_case.GetTokenUC
import com.tochapps.alfredotoolbox.data.network.repository.toolboxdata.ToolBoxRepository
import com.tochapps.alfredotoolbox.data.network.use_cases.remote.ToolBoxLoginUC
import com.tochapps.alfredotoolbox.data.network.use_cases.remote.ToolBoxMoviesUC
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
    fun provideLoginUseCase(
        repository: ToolBoxRepository,
        addTokenUC: AddTokenUC
    ): ToolBoxLoginUC = ToolBoxLoginUC(repository, addTokenUC)

    @Singleton
    @Provides
    fun provideMovieUseCase(
        repository: ToolBoxRepository,
        getTokenUC: GetTokenUC
    ): ToolBoxMoviesUC = ToolBoxMoviesUC(repository, getTokenUC)
}