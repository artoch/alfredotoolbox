package com.tochapps.alfredotoolbox.common


import com.tochapps.alfredotoolbox.common.DataState.Companion.errorData
import com.tochapps.alfredotoolbox.common.error.ExceptionMapper
import com.tochapps.alfredotoolbox.common.extension.handleExceptionMapper
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
            emit(errorData<T>(error))
        }
    }.asCommonFlow()

}