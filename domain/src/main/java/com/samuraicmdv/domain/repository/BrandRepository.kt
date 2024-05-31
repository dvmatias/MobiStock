package com.samuraicmdv.domain.repository

import com.samuraicmdv.domain.model.ProductBrandsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

interface BrandRepository {

    /**
     * Gets the product brands.
     *
     * @param storeId Store's unique identifier.
     */
    suspend fun getProductBrands(storeId: Int): ResponseWrapper<ProductBrandsResponseModel>
}