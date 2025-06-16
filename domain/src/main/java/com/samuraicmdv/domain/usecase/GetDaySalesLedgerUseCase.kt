package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.GetDaySalesLedgerResponseModel

interface GetDaySalesLedgerUseCase {
    suspend operator fun invoke(params: Params): GetDaySalesLedgerResponseModel

    /**
     * Parameters for fetching daily sales ledge.
     *
     * @param storeId The ID of the store for which to fetch the sales ledge.
     * @param day The day of the month for which to fetch the sales ledge.
     * @param month The month for which to fetch the sales ledge.
     * @param year The year for which to fetch the sales ledge.
     */
    data class Params(
        val storeId: Int,
        val day: Int,
        val month: Int,
        val year: Int,
    )
}
