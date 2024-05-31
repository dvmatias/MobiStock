package com.samuraicmdv.data.datasource

import com.samuraicmdv.domain.model.ProductBrandsResponseModel
import com.samuraicmdv.domain.util.ResponseWrapper

/**
 * TODO
 */
interface BrandDataSource {
    /**
     * Gets the product brands.
     *
     * @param storeId Store's unique identifier.
     */
    suspend fun getProductBrands(
        storeId: Int,
    ): ResponseWrapper<ProductBrandsResponseModel>
}