package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.repository.SalesLedgeRepository
import javax.inject.Inject

// TODO
class GetDailySalesLedgeUseCaseImpl @Inject constructor(
    private val repository: SalesLedgeRepository,
) : GetDailySalesLedgeUseCase {

    override suspend operator fun invoke(params: GetDailySalesLedgeUseCase.Params): Any? {
        return null // TODO
    }

}