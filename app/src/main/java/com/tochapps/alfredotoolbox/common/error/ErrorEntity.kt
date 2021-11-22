package com.tochapps.alfredotoolbox.common.error

import com.tochapps.alfredotoolbox.common.EMPTY_STRING
import com.tochapps.alfredotoolbox.common.ERROR_TOKEN
import com.tochapps.alfredotoolbox.common.NO_AUTH
import com.tochapps.alfredotoolbox.common.NO_TOKEN
import com.tochapps.alfredotoolbox.data.state.error.LoginErrorState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorEntity(
    @SerialName("message") val message: String = EMPTY_STRING,
    @SerialName("code") val code: String = EMPTY_STRING,
)

fun ErrorEntity.toErrorDomain() = when (code){
    NO_TOKEN -> LoginErrorState.NoToken
    NO_AUTH  -> LoginErrorState.NoAuth
    ERROR_TOKEN -> LoginErrorState.ErrorToken
    else -> CommonError.GenericServiceError
}