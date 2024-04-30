package com.samuraicmdv.domain.util

sealed class ResponseFailure(open var exception: String?) {
    data object None: ResponseFailure(null)
    class ConnectionError(override var exception: String?): ResponseFailure(exception)
    class ServerError(override var exception: String?): ResponseFailure(exception)
    class LocalError(override var exception: String?): ResponseFailure(exception)
    data object TransformationError: ResponseFailure("Transformation error.")
}