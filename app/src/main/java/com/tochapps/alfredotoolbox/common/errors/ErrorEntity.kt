package com.tochapps.alfredotoolbox.common.errors

import com.tochapps.alfredotoolbox.common.EMPTY_STRING
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorEntity(
    @SerialName("error") val error: ErrorDataEntity = ErrorDataEntity(),
)

@Serializable
data class ErrorDataEntity(
    @SerialName("message") val message: String = EMPTY_STRING,
    @SerialName("name") val name: String = EMPTY_STRING,
    @SerialName("statusCode") val statusCode: Int = 0,
)