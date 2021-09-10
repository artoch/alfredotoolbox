package com.tochapps.practicetestapp.common.errors

import com.tochapps.practicetestapp.common.ExceptionMapper
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

object GenericErrorMapper : ExceptionMapper {

    override fun getCustomError(errorEntity: ErrorEntity) = CommonError.GenericServiceError

    override fun getGenericError(exception: Exception) = CommonError.GenericServiceError
}