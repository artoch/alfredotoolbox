package com.tochapps.alfredotoolbox.data.network.service.testdata

import com.tochapps.alfredotoolbox.data.model.PostItemEntity

interface TestService {
    suspend fun getAllPost(): List<PostItemEntity>
}