package com.tochapps.alfredotoolbox.data.network.use_cases.retroRemote

import com.tochapps.alfredotoolbox.common.BaseUseCase
import com.tochapps.alfredotoolbox.common.DataState
import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.error.GenericErrorMapper
import com.tochapps.alfredotoolbox.common.error.toErrorDomain
import com.tochapps.alfredotoolbox.common.extension.toErrorEntity
import com.tochapps.alfredotoolbox.data.local.model.getToken
import com.tochapps.alfredotoolbox.data.local.use_case.GetTokenUC
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.data.network.repository.toolboxRetro.ToolBoxRepositoryRetro
import javax.inject.Inject

class RetroToolBoxMoviesUC @Inject constructor(
    private val repository: ToolBoxRepositoryRetro,
    private val getTokenUC: GetTokenUC
) : BaseUseCase() {

    operator fun invoke() = handlerErrorMapper<List<ToolBoxListEntity>>(GenericErrorMapper) {
        emit(DataState.loading())
        val token = getTokenUC.invoke().getToken()
        val result = repository.getMovies(
            token
        )
        if (result.isSuccessful){
            emit(DataState.data(result.body()))
        }else{
            emit(DataState.errorData(result.toErrorEntity()))
        }
    }.asCommonFlow()
}