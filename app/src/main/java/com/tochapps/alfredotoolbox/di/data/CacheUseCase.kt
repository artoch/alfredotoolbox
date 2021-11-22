package com.tochapps.alfredotoolbox.di.data

import com.tochapps.alfredotoolbox.data.local.repository.tokendata.TokenRoomRepositoryImpl
import com.tochapps.alfredotoolbox.data.local.use_case.AddTokenUC
import com.tochapps.alfredotoolbox.data.local.use_case.DeleteTokenUC
import com.tochapps.alfredotoolbox.data.local.use_case.GetTokenUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object CacheUseCase {

    @Singleton
    @Provides
    fun provideGetTestCacheUseCase(
        dao: TokenRoomRepositoryImpl
    ): GetTokenUC = GetTokenUC(dao)

//    @Singleton
//    @Provides
//    fun provideListTestCacheUseCase(
//        dao: TokenRoomRepository
//    ): ListTestCacheUC = ListTestCacheUC(dao)

    @Singleton
    @Provides
    fun provideDeleteTestCacheUseCase(
        dao: TokenRoomRepositoryImpl
    ): DeleteTokenUC = DeleteTokenUC(dao)

    @Singleton
    @Provides
    fun provideAddTestCacheUseCase(
        dao: TokenRoomRepositoryImpl
    ): AddTokenUC = AddTokenUC(dao)
}