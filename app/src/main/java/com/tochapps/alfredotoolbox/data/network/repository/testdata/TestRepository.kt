package com.tochapps.alfredotoolbox.data.network.repository.testdata

import com.tochapps.alfredotoolbox.data.model.PostItemEntity

interface TestRepository {
    suspend fun getAllPost(): List<PostItemEntity>
}