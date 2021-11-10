package com.tochapps.alfredotoolbox.common.error

sealed class ValidateContactError : ErrorDomain() {

    object ContactAlreadyError : ValidateContactError()
}