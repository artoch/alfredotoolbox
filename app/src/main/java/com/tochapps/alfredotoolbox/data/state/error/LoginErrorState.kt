package com.tochapps.alfredotoolbox.data.state.error

import com.tochapps.alfredotoolbox.common.error.ErrorDomain

sealed class LoginErrorState : ErrorDomain() {

    object NoToken : LoginErrorState()
    object NoAuth  : LoginErrorState()
    object ErrorToken   : LoginErrorState()
}