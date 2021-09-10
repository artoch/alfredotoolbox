package com.tochapps.practicetestapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostItemEntity (
    @SerialName("id")     val id:Long,
    @SerialName("userId") val userId: Int,
    @SerialName("title")  val title: String,
    @SerialName("body")   val body: String,
)