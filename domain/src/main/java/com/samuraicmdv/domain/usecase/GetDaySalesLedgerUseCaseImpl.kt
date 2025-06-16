package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel
import com.samuraicmdv.domain.repository.SalesLedgerRepository
import javax.inject.Inject

// TODO
class GetDaySalesLedgerUseCaseImpl @Inject constructor(
    private val repository: SalesLedgerRepository,
) : GetDaySalesLedgerUseCase {

    override suspend operator fun invoke(params: GetDaySalesLedgerUseCase.Params): GetDaySalesLedgerResponseModel {
        val response = repository.getDaySalesLedger(
            storeId = params.storeId,
            day = params.day,
            month = params.month,
            year = params.year
        )
        return response.getOrNull() ?: GetDaySalesLedgerResponseModel(
            errorMessage = response.failure?.exception,
            daySalesLedger = null
        )
    }
}