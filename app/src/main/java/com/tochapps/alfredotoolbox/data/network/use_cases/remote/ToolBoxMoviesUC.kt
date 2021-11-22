package com.tochapps.alfredotoolbox.data.network.use_cases.remote

import com.tochapps.alfredotoolbox.common.BaseUseCase
import com.tochapps.alfredotoolbox.common.DataState
import com.tochapps.alfredotoolbox.common.NO_TOKEN
import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.error.ErrorStatus
import com.tochapps.alfredotoolbox.common.error.GenericErrorMapper
import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity
import com.tochapps.alfredotoolbox.data.local.model.getToken
import com.tochapps.alfredotoolbox.data.local.use_case.GetTokenUC
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.data.network.repository.toolboxdata.ToolBoxRepository
import com.tochapps.alfredotoolbox.data.state.AppState
import com.tochapps.alfredotoolbox.data.state.error.LoginErrorMapper
import javax.inject.Inject

class ToolBoxMoviesUC @Inject constructor(
    private val repository: ToolBoxRepository,
    private val getTokenUC: GetTokenUC
) : BaseUseCase() {

    operator fun invoke() = handlerErrorMapper<List<ToolBoxListEntity>>(LoginErrorMapper) {
        emit(DataState.loading())
        val token = getTokenUC.invoke()
        val data = repository.getMovies(token.getToken())
        emit(DataState.data(data))

    }.asCommonFlow()
}