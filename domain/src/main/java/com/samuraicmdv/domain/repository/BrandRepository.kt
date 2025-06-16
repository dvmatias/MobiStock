package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.GetBrandsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface BrandRepository {

    /**
     * Gets the item brands.
     *
     * @param storeId Store's unique identifier.
     */
    suspend fun getBrands(storeId: Int): ResponseWrapper<GetBrandsResponseModel>
}