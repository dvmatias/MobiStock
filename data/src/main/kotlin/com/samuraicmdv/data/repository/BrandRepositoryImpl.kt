package com.samuraicmdv.data.repository

import com.samuraicmdv.data.datasource.BrandDataSource
import com.samuraicmdv.domain.model.GetBrandsResponseModel
import com.samuraicmdv.domain.repository.BrandRepository
import com.samuraicmdv.domain.util.ResponseWrapper
import javax.inject.Inject

class BrandRepositoryImpl @Inject constructor(
    private val brandDataSource: BrandDataSource
) : BrandRepository {

    override suspend fun getBrands(
        storeId: Int,
    ): ResponseWrapper<GetBrandsResponseModel> =
        brandDataSource.getBrands(storeId)
}