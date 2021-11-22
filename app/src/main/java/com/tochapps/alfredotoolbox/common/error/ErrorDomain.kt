package com.tochapps.alfredotoolbox.common.error

import com.tochapps.alfredotoolbox.common.EMPTY_STRING
import com.tochapps.alfredotoolbox.data.state.AppState


abstract class ErrorDomain

sealed class ErrorStatus: ErrorDomain(){
    class ErrorMsg(val msg:String = EMPTY_STRING): ErrorStatus()
    class ErrorMsgCode(val msg:String = EMPTY_STRING, val code:String = EMPTY_STRING): ErrorStatus()
}
