package com.tochapps.alfredotoolbox.data.local.dao.tokendata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TokenDao {
    @Query("SELECT * FROM token_table WHERE id = :id")
    suspend fun getToken(id:Long): TokenRoomEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToken(tokenRoomEntity: TokenRoomEntity)

    @Query("DELETE FROM token_table")
    suspend fun deleteToken()
}