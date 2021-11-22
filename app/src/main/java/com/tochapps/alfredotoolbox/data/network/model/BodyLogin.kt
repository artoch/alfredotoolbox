package com.tochapps.alfredotoolbox.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BodyLogin (
    @SerialName("sub") val sub:String
)