package com.tochapps.alfredotoolbox.common

const val EMPTY_STRING = ""
const val ERROR_TOKEN = "E403"
const val NO_TOKEN = "E402"
const val NO_AUTH = "E401"
const val POSTER = "poster"
const val THUMB = "thumb"
const val DATABASE_NAME = "TEST_DATABASE"

class URLS{
    companion object {
        const val LOGIN = "v1/mobile/auth"
        const val GET_MOVIES = "v1/mobile/data"
    }
}

class HEADERS {
    companion object {
        const val AUTH = "authorization"
    }
}