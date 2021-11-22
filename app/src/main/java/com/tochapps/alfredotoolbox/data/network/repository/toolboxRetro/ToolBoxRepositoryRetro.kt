package com.tochapps.alfredotoolbox.data.network.repository.toolboxRetro

import com.tochapps.alfredotoolbox.data.network.model.BodyLogin
import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.LoginEntityRetro
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import retrofit2.Response

interface ToolBoxRepositoryRetro {
    suspend fun loginToolBox(bodyLogin: BodyLogin): Response<LoginEntity>

    suspend fun getMovies(token:String): Response<List<ToolBoxListEntity>>
}