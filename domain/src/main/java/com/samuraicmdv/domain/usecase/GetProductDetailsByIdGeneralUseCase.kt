package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsModel
import com.samuraicmdv.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * Use case for fetching general product details by product ID.
 *
 * @param productRepository The repository to access product data.
 */
class GetProductDetailsByIdGeneralUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsModel =
        productRepository.getProductDetailsByIdGeneral(params.productId)
            .getOrNull()
            ?.productDetails
            ?: throw Exception("Product not found") // TODO Handle case

    /**
     * Parameters for fetching general product details.
     *
     * @param productId The ID of the product to retrieve details for.
     */
    data class Params(
        val productId: Int
    )
}