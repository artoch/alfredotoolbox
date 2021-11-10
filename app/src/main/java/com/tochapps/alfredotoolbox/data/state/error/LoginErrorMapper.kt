package com.tochapps.alfredotoolbox.data.state.error

import com.tochapps.alfredotoolbox.common.ERROR_TOKEN
import com.tochapps.alfredotoolbox.common.NO_AUTH
import com.tochapps.alfredotoolbox.common.NO_TOKEN
import com.tochapps.alfredotoolbox.common.error.CommonError
import com.tochapps.alfredotoolbox.common.error.ErrorEntity
import com.tochapps.alfredotoolbox.common.error.ExceptionMapper

object LoginErrorMapper : ExceptionMapper {

    override fun getCustomError(errorEntity: ErrorEntity)  = when (errorEntity.statusCode) {
        NO_TOKEN -> LoginErrorState.NoToken
        NO_AUTH  -> LoginErrorState.NoAuth
        ERROR_TOKEN -> LoginErrorState.ErrorToken
        else -> CommonError.GenericServiceError
    }

    override fun getGenericError(exception: Exception) = CommonError.GenericServiceError
}