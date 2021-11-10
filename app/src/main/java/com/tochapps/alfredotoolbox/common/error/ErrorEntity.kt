package com.tochapps.alfredotoolbox.common.error

import com.tochapps.alfredotoolbox.common.EMPTY_STRING
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorEntity(
    @SerialName("message") val message: String = EMPTY_STRING,
    @SerialName("code") val statusCode: String = EMPTY_STRING,
)