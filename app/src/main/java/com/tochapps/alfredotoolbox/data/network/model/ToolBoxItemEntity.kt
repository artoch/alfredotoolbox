package com.tochapps.alfredotoolbox.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ToolBoxItemEntity (
    @SerialName("title")        val title: String,
    @SerialName("imageUrl")     val imageUrl: String,
    @SerialName("videoUrl")     val videoUrl: String? = null,
    @SerialName("description")  val description: String
)