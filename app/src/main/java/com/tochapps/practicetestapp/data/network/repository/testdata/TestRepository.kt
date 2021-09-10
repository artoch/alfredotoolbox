package com.tochapps.practicetestapp.data.network.repository.testdata

import com.tochapps.practicetestapp.data.model.PostItemEntity

interface TestRepository {
    suspend fun getAllPost(): List<PostItemEntity>
}