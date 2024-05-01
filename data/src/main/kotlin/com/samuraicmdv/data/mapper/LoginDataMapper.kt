package com.samuraicmdv.data.mapper

import com.samuraicmdv.data.entity.ErrorEntity
import com.samuraicmdv.data.entity.LoginResponseEntity
import com.samuraicmdv.domain.base.DataMapper
import com.samuraicmdv.domain.model.LoginErrorModel
import com.samuraicmdv.domain.model.LoginResponseModel

object LoginDataMapper : DataMapper<LoginResponseEntity?, LoginResponseModel?> {
    override fun entityToModel(entity: LoginResponseEntity?): LoginResponseModel? {
        return entity?.let { e ->
            LoginResponseModel(
                errors = transformErrors(e.meta?.errors),
            )
        }
    }

    private fun transformErrors(errors: List<ErrorEntity>?): List<LoginErrorModel>? =
        errors?.map { error ->
            LoginErrorModel(code = error.code, description = error.description)
        }

}

