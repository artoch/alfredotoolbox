package com.tochapps.alfredotoolbox.data.network.service.testdata

import com.tochapps.alfredotoolbox.data.model.PostItemEntity
import io.ktor.client.*
import io.ktor.client.request.*

class TestServiceImpl constructor(
    private val httpClient: HttpClient,
    private val baseUrl: String)
    :TestService{

    val URL_LIST = "posts/"

    override suspend fun getAllPost(): List<PostItemEntity> = httpClient.get{
        url("$baseUrl$URL_LIST")
    }
}