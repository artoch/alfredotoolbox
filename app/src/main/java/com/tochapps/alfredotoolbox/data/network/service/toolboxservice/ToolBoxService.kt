package com.tochapps.alfredotoolbox.data.network.service.toolboxservice

import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity


interface ToolBoxService {


    suspend fun loginToolBox(): LoginEntity

    suspend fun getMovies(token:String): List<ToolBoxListEntity>
}