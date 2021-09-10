package com.tochapps.practicetestapp.data.network.service.testdata

import com.tochapps.practicetestapp.data.model.PostItemEntity
import com.tochapps.practicetestapp.di.KtorModule
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Named

class TestServiceImpl constructor(
    private val httpClient: HttpClient,
    private val baseUrl: String)
    :TestService{

    val URL_LIST = "posts/"

    override suspend fun getAllPost(): List<PostItemEntity> = httpClient.get{
        url("$baseUrl$URL_LIST")
    }
}