package com.tochapps.practicetestapp.data.network.service.testdata

import com.tochapps.practicetestapp.data.model.PostItemEntity

interface TestService {
    suspend fun getAllPost(): List<PostItemEntity>
}