package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.local.dao.tokendata.TokenDao
import com.tochapps.alfredotoolbox.data.local.repository.tokendata.TokenRoomRepository
import com.tochapps.alfredotoolbox.data.local.repository.tokendata.TokenRoomRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object RepositoryCacheModule {
    @Singleton
    @Provides
    fun provideTestRepository(
        dao: TokenDao
    ): TokenRoomRepository = TokenRoomRepositoryImpl(
        dao
    )
}