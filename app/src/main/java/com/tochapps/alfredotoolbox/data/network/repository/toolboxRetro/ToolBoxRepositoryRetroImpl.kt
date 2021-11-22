package com.tochapps.alfredotoolbox.data.network.repository.toolboxRetro

import com.tochapps.alfredotoolbox.data.network.model.BodyLogin
import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.LoginEntityRetro
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.data.retrofitNetwork.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class ToolBoxRepositoryRetroImpl   @Inject constructor(
    private val service: ApiService
) : ToolBoxRepositoryRetro {

    override suspend fun loginToolBox(bodyLogin: BodyLogin): Response<LoginEntity> = service.login(bodyLogin)

    override suspend fun getMovies(token:String): Response<List<ToolBoxListEntity>> = service.getAllMovies(token)
}