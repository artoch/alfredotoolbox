package com.tochapps.alfredotoolbox.common

import com.tochapps.alfredotoolbox.common.errors.ErrorDomain
import com.tochapps.alfredotoolbox.common.errors.ErrorEntity

interface ExceptionMapper {

    fun getCustomError(errorEntity: ErrorEntity): ErrorDomain

    fun getGenericError(exception: Exception): ErrorDomain
}