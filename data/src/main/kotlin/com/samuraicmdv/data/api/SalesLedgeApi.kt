package com.samuraicmdv.data.api

import com.samuraicmdv.data.entity.GetSalesLedgeResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SalesLedgeApi {

    @GET("${PATH}/$GET_PATH")
    suspend fun getDailySalesLedge(
        @Query("store_id") storeId: Int,
        @Query("day") day: Int,
        @Query("month") month: Int,
        @Query("year") year: Int,
    ): Response<GetSalesLedgeResponseEntity>

    companion object {
        private const val PATH = "sales-record"
        private const val GET_PATH = "get"
    }
}