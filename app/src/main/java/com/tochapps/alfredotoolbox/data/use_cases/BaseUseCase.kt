package com.tochapps.alfredotoolbox.data.use_cases

import com.tochapps.alfredotoolbox.common.CommonFlow
import com.tochapps.alfredotoolbox.common.ExceptionMapper
import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.extension.handleExceptionMapper
import com.tochapps.alfredotoolbox.data.state.DataState
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

abstract class BaseUseCase {

    protected fun <T> handlerErrorMapper(
        exceptionMapper: ExceptionMapper,
        action: suspend FlowCollector<DataState<T>>.() -> Unit
    ): CommonFlow<DataState<T>> = flow {
        try {
            this.action()
        } catch (e: Exception) {
            val error = e.handleExceptionMapper(exceptionMapper)
            error(error)
        }
    }.asCommonFlow()
}