package com.tochapps.alfredotoolbox.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ToolBoxListEntity (
    @SerialName("title")    val title:String,
    @SerialName("type")     val type: String,
    @SerialName("items")    val items: List<ToolBoxItemEntity>
)