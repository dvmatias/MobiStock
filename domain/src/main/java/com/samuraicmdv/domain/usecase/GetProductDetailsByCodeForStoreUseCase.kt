package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * Use case for fetching product details by product code for a specific store.
 *
 * @param productRepository The repository to access product data.
 */
class GetProductDetailsByCodeForStoreUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsResponseModel =
        productRepository.getProductDetailsByCodeForStore(
            params.productCode,
            params.storeId
        ) ?: throw Exception("Product not found") // TODO Handle case

    /**
     * Parameters for fetching product details for a specific store.
     *
     * @param productCode The code of the product to retrieve details for.
     * @param storeId The ID of the store for which to retrieve product details.
     */
    data class Params(
        val productCode: String,
        val storeId: Int,
    )
}