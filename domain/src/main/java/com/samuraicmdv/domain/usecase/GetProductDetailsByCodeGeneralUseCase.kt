package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsModel
import com.samuraicmdv.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * Use case for fetching general product details by product code.
 *
 * @param productRepository The repository to access product data.
 */
class GetProductDetailsByCodeGeneralUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsModel =
        productRepository.getProductDetailsByCodeGeneral(params.productCode)
            .getOrNull()
            ?.productDetails
            ?: throw Exception("Product not found") // TODO Handle case

    /**
     * Parameters for fetching general product details.
     *
     * @param productCode The code of the product to retrieve details for.
     */
    data class Params(
        val productCode: String,
    )
}