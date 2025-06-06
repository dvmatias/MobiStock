package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsModel
import com.samuraicmdv.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * Use case for fetching product details for a specific store.
 *
 * @param productRepository The repository to access product data.
 */
class GetProductDetailsForStoreUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsModel =
        productRepository.getProductDetailsForStore(
            params.productId,
            params.storeId
        ).getOrNull()?.productDetails
            ?: throw Exception("Product not found") // TODO Handle case

    /**
     * Parameters for fetching product details for a specific store.
     *
     * @param productId The ID of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    data class Params(
        val productId: Int,
        val storeId: Int,
    )
}