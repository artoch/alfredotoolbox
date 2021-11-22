package com.tochapps.alfredotoolbox.data.network.use_cases.remote

import android.util.Log
import com.tochapps.alfredotoolbox.common.BaseUseCase
import com.tochapps.alfredotoolbox.common.DataState
import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.error.GenericErrorMapper
import com.tochapps.alfredotoolbox.data.local.use_case.AddTokenUC
import com.tochapps.alfredotoolbox.data.network.model.LoginEntity
import com.tochapps.alfredotoolbox.data.network.model.toRoom
import com.tochapps.alfredotoolbox.data.network.repository.toolboxdata.ToolBoxRepository
import com.tochapps.alfredotoolbox.data.state.error.LoginErrorMapper
import javax.inject.Inject

class ToolBoxLoginUC @Inject constructor(
    private val repository: ToolBoxRepository,
    private val addTokenUC: AddTokenUC
) : BaseUseCase() {

    operator fun invoke() = handlerErrorMapper<LoginEntity>(LoginErrorMapper) {
        emit(DataState.loading())
        val data = repository.loginToolBox()
        Log.e("VM","$data")
        addTokenUC.invoke(data.toRoom())
        emit(DataState.data(data))
    }.asCommonFlow()
}