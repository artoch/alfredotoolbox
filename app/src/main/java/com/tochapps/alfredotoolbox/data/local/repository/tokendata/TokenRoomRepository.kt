package com.tochapps.alfredotoolbox.data.local.repository.tokendata

import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity

interface TokenRoomRepository {
    suspend fun getToken(id:Long): TokenRoomEntity?

    suspend fun addToken(postItemEntity: TokenRoomEntity)

    suspend fun deleteToken()
}