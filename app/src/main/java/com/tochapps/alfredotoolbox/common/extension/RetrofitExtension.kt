package com.tochapps.alfredotoolbox.common.extension

import com.google.gson.Gson
import com.tochapps.alfredotoolbox.common.ERROR_TOKEN
import com.tochapps.alfredotoolbox.common.NO_AUTH
import com.tochapps.alfredotoolbox.common.NO_TOKEN
import com.tochapps.alfredotoolbox.common.error.CommonError
import com.tochapps.alfredotoolbox.common.error.ErrorEntity
import com.tochapps.alfredotoolbox.data.state.error.LoginErrorState
import okhttp3.ResponseBody
import retrofit2.Response


fun <T> Response<T>.toErrorEntity() =
     when (
        Gson().fromJson(
            errorBody()!!.charStream(),
            ErrorEntity::class.java
        ).code
    ){
        NO_TOKEN -> LoginErrorState.NoToken
        NO_AUTH  -> LoginErrorState.NoAuth
        ERROR_TOKEN -> LoginErrorState.ErrorToken
        else -> CommonError.GenericServiceError
    }

fun ResponseBody.toErrorEntity(): ErrorEntity {
    val gson = Gson()
    return gson.fromJson(
        this.charStream(),
        ErrorEntity::class.java
    )
}