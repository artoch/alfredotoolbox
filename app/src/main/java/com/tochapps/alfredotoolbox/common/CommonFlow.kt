package com.tochapps.alfredotoolbox.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)

class CommonFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {

    fun collectCommon(
        coroutineScope: CoroutineScope?, // 'viewModelScope' on Android and 'nil' on iOS
        callback: (T) -> Unit, // callback on each emission
    ) = onEach {
        callback(it)
    }.launchIn(coroutineScope ?: CoroutineScope(Dispatchers.Main))
}
