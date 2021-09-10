package com.tochapps.practicetestapp.data.use_cases

import com.tochapps.practicetestapp.common.CommonFlow
import com.tochapps.practicetestapp.common.ExceptionMapper
import com.tochapps.practicetestapp.common.asCommonFlow
import com.tochapps.practicetestapp.common.extension.handleExceptionMapper
import com.tochapps.practicetestapp.data.state.DataState
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