package com.samuraicmdv.domain.model

data class GetDaySalesLedgerResponseModel(
    val errorMessage: String? = null,
    val daySalesLedger: DaySalesLedgerModel? = null
)
