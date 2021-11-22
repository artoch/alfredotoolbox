package com.tochapps.alfredotoolbox.data.network.service.toolboxservice

import com.tochapps.alfredotoolbox.common.HEADERS
import com.tochapps.alfredotoolbox.common.URLS
import com.tochapps.alfredotoolbox.data.network.model.BodyLogin
import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import io.ktor.client.*
import io.ktor.client.request.*

class ToolBoxServiceImpl constructor(
    private val httpClient: HttpClient,
    private val baseUrl: String)
: ToolBoxService {

    override suspend fun loginToolBox(): LoginEntity =
        httpClient.post{
            url(baseUrl + URLS.LOGIN)
            body = BodyLogin(
                sub = "ToolboxMobileTest"
            )
        }


    override suspend fun getMovies(token: String): List<ToolBoxListEntity> =
        httpClient.get {
            url(baseUrl + URLS.GET_MOVIES)
            header(HEADERS.AUTH, token)
        }

}