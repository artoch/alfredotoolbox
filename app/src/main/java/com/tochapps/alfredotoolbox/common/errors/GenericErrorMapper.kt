package com.tochapps.alfredotoolbox.common.errors

import com.tochapps.alfredotoolbox.common.ExceptionMapper

object GenericErrorMapper : ExceptionMapper {

    override fun getCustomError(errorEntity: ErrorEntity) = CommonError.GenericServiceError

    override fun getGenericError(exception: Exception) = CommonError.GenericServiceError
}