package com.tochapps.practicetestapp.data.network.repository.testdata

import com.tochapps.practicetestapp.data.model.PostItemEntity
import com.tochapps.practicetestapp.data.network.service.testdata.TestService
import com.tochapps.practicetestapp.di.KtorModule.BASE_URL_KEY
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

class TestRepositoryImpl  @Inject constructor(
    private val service: TestService
):TestRepository {
    override suspend fun getAllPost(): List<PostItemEntity> = service.getAllPost()
}