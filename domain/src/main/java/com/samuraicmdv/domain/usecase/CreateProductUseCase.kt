package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.repository.ProductRepository
import javax.inject.Inject

class CreateProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(params: Params) =
        productRepository.createProduct(
            name = params.name,
            shortDescription = params.shortDescription,
            longDescription = params.longDescription,
            code = params.code,
            model = params.model,
            categoryId = params.categoryId,
            brandId = params.brandId,
            sku = params.sku,
            selling = params.selling,
            cost = params.cost,
            currencyId = params.currencyId,
            storeId = params.storeId,
            preferredMargin = params.preferredMargin
        ).let {
            it.getOrNull() ?: throw Exception("CreateProductUseCase failed")
        }

    data class Params(
        val name: String,
        val shortDescription: String,
        val longDescription: String,
        val code: String?,
        val model: String?,
        val categoryId: Int,
        val brandId: Int,
        val sku: String?,
        val selling: String?,
        val cost: String?,
        val currencyId: String?,
        val storeId: String?,
        val preferredMargin: Int?
    )

}