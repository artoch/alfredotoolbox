package com.tochapps.practicetestapp.common.extension

import com.tochapps.practicetestapp.common.ExceptionMapper
import com.tochapps.practicetestapp.common.errors.CommonError
import com.tochapps.practicetestapp.common.errors.ErrorDomain
import com.tochapps.practicetestapp.common.errors.ErrorEntity
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.network.sockets.*

suspend fun Exception.toErrorEntity(): ErrorEntity? =
    try {
        (this as? ResponseException)?.response?.receive<ErrorEntity>()
    } catch (t: Exception) {
        null
    } catch (t: RuntimeException) {
        null
    } catch (t: Throwable) {
        null
    }

suspend fun Exception.handleExceptionMapper(mapper: ExceptionMapper): ErrorDomain =
    this.toErrorEntity()?.let { mapper.getCustomError(it) } ?: this.toCommonError()
    ?: mapper.getGenericError(this)

fun Exception.toCommonError(): ErrorDomain? = when (this) {
    is ConnectTimeoutException, is SocketTimeoutException -> CommonError.ConnectError
    else -> null
}

inline fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

inline fun <T1 : Any, T2 : Any, T3 : Any, R : Any> safeLet(p1: T1?, p2: T2?, p3: T3?, block: (T1, T2, T3) -> R?): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}

inline fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, R : Any> safeLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    p4: T4?,
    block: (T1, T2, T3, T4) -> R?
): R? {
    return if (p1 != null && p2 != null && p3 != null && p4 != null) block(p1, p2, p3, p4) else null
}

inline fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, R : Any> safeLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    p4: T4?,
    p5: T5?,
    block: (T1, T2, T3, T4, T5) -> R?
): R? {
    return if (p1 != null && p2 != null && p3 != null && p4 != null && p5 != null) block(p1, p2, p3, p4, p5) else null
}