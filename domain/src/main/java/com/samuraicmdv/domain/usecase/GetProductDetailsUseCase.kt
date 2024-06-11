package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsModel
import com.samuraicmdv.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsModel =
        productRepository.getProductDetails(params.productId).getOrNull()?.productDetails
            ?: throw Exception("Product not found") // TODO Handle case

    data class Params(
        val productId: Int,
    )
}