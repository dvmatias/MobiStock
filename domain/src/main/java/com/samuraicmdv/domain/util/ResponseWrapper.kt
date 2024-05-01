package com.samuraicmdv.domain.util

class ResponseWrapper<out T>(
    private val data: T?,
    private val responseStatus: ResponseStatus,
    private val responseFailure: ResponseFailure?,
) {

    val isSuccess: Boolean = data !== failMarker

    val isFailure: Boolean = data === failMarker

    @Suppress("UNCHECKED_CAST")
    fun getOrNull(): T? = if (isSuccess) data as T else null

    companion object {
        private val failMarker = object {}

        fun <T> success(data: T?): ResponseWrapper<T> =
            ResponseWrapper(data, ResponseStatus.SUCCESS, null)

        fun <T> error(data: T? = null, responseFailure: ResponseFailure): ResponseWrapper<T> =
            ResponseWrapper(data, ResponseStatus.ERROR, responseFailure)
    }

}