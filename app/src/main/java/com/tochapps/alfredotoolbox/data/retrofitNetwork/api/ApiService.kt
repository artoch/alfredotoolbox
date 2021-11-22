package com.tochapps.alfredotoolbox.data.retrofitNetwork.api

import com.tochapps.alfredotoolbox.common.HEADERS
import com.tochapps.alfredotoolbox.common.URLS
import com.tochapps.alfredotoolbox.data.network.model.BodyLogin
import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.LoginEntityRetro
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST(URLS.LOGIN)
    suspend fun login(
        @Body bodyLogin: BodyLogin
    ): Response<LoginEntity>

    @GET(URLS.GET_MOVIES)
    suspend fun getAllMovies(
        @Header(HEADERS.AUTH) token:String)
            : Response<List<ToolBoxListEntity>>
}