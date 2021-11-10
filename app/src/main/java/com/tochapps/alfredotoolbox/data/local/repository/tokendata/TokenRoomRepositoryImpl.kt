package com.tochapps.alfredotoolbox.data.local.repository.tokendata

import com.tochapps.alfredotoolbox.data.local.dao.tokendata.TokenDao
import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity
import javax.inject.Inject

class TokenRoomRepositoryImpl @Inject constructor(
    private val tokenDao: TokenDao
): TokenRoomRepository  {

    override suspend fun getToken(id:Long): TokenRoomEntity? = tokenDao.getToken(id)

    override suspend fun addToken(postItemEntity: TokenRoomEntity) {
        tokenDao.addToken(postItemEntity)
    }

    override suspend fun deleteToken() {
        tokenDao.deleteToken()
    }
}