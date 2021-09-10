package com.tochapps.practicetestapp.common

import com.tochapps.practicetestapp.common.errors.ErrorDomain
import com.tochapps.practicetestapp.common.errors.ErrorEntity

interface ExceptionMapper {

    fun getCustomError(errorEntity: ErrorEntity): ErrorDomain

    fun getGenericError(exception: Exception): ErrorDomain
}