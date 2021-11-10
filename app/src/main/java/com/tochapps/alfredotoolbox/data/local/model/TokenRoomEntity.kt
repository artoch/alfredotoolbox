package com.tochapps.alfredotoolbox.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tochapps.alfredotoolbox.common.EMPTY_STRING

@Entity(tableName = "token_table")
data class TokenRoomEntity (
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    val sub: String,
    val token: String,
    val type: String,
)

fun TokenRoomEntity?.getToken():String =
    if (this != null) "${this.type} ${this.token}" else EMPTY_STRING