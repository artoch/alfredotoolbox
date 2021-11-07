package com.tochapps.alfredotoolbox.data.network.repository.testdata

import com.tochapps.alfredotoolbox.data.model.PostItemEntity
import com.tochapps.alfredotoolbox.data.network.service.testdata.TestService
import javax.inject.Inject

class TestRepositoryImpl  @Inject constructor(
    private val service: TestService
):TestRepository {
    override suspend fun getAllPost(): List<PostItemEntity> = service.getAllPost()
}