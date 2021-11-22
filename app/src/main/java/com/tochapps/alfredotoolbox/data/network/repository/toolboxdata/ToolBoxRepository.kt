package com.tochapps.alfredotoolbox.data.network.repository.toolboxdata

import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity

interface ToolBoxRepository {

    suspend fun loginToolBox(): LoginEntity

    suspend fun getMovies(token:String): List<ToolBoxListEntity>
}