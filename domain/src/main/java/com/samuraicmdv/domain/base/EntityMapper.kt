package com.samuraicmdv.domain.base

/**
 * Interface Base Class - Base class to be implemented by every data mapper. Each data mapper
 * converts data layer model (entity) into domain layer model (model) and vice versa.
 *
 * @param E Entity - data layer data model object.
 * @param M Model - model layer data model object.
 */
interface EntityMapper<E, M> {
    fun map(entity: E?): M? {
        throw UnsupportedOperationException()
    }
}