package com.tochapps.alfredotoolbox.data.network.model

import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginEntity (
    @SerialName("sub")     val sub:   String,
    @SerialName("token")   val token: String,
    @SerialName("type")    val type:  String
)

fun LoginEntity.toRoom() = TokenRoomEntity(
    id = 1, sub = sub, token = token, type = type
)