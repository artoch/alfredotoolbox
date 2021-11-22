package com.tochapps.alfredotoolbox.data.network.use_cases.retroRemote

import com.tochapps.alfredotoolbox.common.BaseUseCase
import com.tochapps.alfredotoolbox.common.DataState
import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.error.GenericErrorMapper
import com.tochapps.alfredotoolbox.common.error.toErrorDomain
import com.tochapps.alfredotoolbox.common.extension.toErrorEntity
import com.tochapps.alfredotoolbox.data.local.use_case.AddTokenUC
import com.tochapps.alfredotoolbox.data.network.model.BodyLogin
import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.toRoom
import com.tochapps.alfredotoolbox.data.network.repository.toolboxRetro.ToolBoxRepositoryRetro
import javax.inject.Inject


class RetroToolBoxLoginUC @Inject constructor(
    private val repository: ToolBoxRepositoryRetro,
    private val addTokenUC: AddTokenUC
) : BaseUseCase() {

    operator fun invoke() = handlerErrorMapper<LoginEntity>(GenericErrorMapper) {
        emit(DataState.loading())
        val result = repository.loginToolBox(BodyLogin(
            sub = "ToolboxMobileTest"
        ))
        if (result.isSuccessful){
            addTokenUC.invoke(result.body()!!.toRoom())
            emit(DataState.data(result.body()))
        }else{
            emit(DataState.errorData(result.toErrorEntity()))
        }
    }.asCommonFlow()
}