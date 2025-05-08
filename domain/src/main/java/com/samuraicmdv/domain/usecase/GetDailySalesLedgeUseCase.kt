package com.samuraicmdv.domain.usecase

interface GetDailySalesLedgeUseCase {
    suspend operator fun invoke(params: Params): Any? // TODO

    // TODO
    data class Params(
        val storeId: Int
    )
}
