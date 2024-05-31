package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.GetBrandsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * TODO
 */
interface BrandDataSource {
    /**
     * Gets all brands from a store.
     *
     * @param storeId Store's unique identifier.
     */
    suspend fun getBrands(
        storeId: Int,
    ): ResponseWrapper<GetBrandsResponseModel>
}