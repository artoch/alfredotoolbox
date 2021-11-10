package com.tochapps.alfredotoolbox.data.network.repository.toolboxdata

import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.data.network.service.toolboxservice.ToolBoxService
import javax.inject.Inject

class ToolBoxRepositoryImpl  @Inject constructor(
    private val service: ToolBoxService
) : ToolBoxRepository {

    override suspend fun loginToolBox(): LoginEntity = service.loginToolBox()

    override suspend fun getMovies(token:String): List<ToolBoxListEntity> = service.getMovies(token)
}