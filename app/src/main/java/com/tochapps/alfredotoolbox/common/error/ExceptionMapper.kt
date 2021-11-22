package com.tochapps.alfredotoolbox.common.error

interface ExceptionMapper {

    fun getCustomError(errorEntity: ErrorEntity): ErrorDomain

    fun getGenericError(exception: Exception): ErrorDomain
}