package com.tochapps.alfredotoolbox.common.errors

sealed class CommonError : ErrorDomain() {

    object ConnectError : CommonError()

    object NotFoundError : CommonError()

    object GenericServiceError : CommonError()
}

fun ErrorDomain?.orGenericError() = this ?: CommonError.GenericServiceError