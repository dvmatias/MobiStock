package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.ErrorEntity
import com.samuraicmdv.data.entity.LoginResponseEntity
import com.samuraicmdv.domain.base.EntityMapper
import com.samuraicmdv.domain.model.LoginErrorModel
import com.samuraicmdv.domain.model.LoginResponseModel

object LoginEntityMapper : EntityMapper<LoginResponseEntity?, LoginResponseModel?> {
    override fun map(entity: LoginResponseEntity?): LoginResponseModel? {
        return entity?.let { e ->
            LoginResponseModel(
                userId = e.userId,
                errors = transformErrors(e.meta?.errors),
            )
        }
    }

    private fun transformErrors(errors: List<ErrorEntity>?): List<LoginErrorModel>? =
        errors?.map { error ->
            LoginErrorModel(code = error.code, description = error.description)
        }

}

