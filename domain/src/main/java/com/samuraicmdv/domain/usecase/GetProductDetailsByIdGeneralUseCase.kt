package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.repository.ItemRepository
import javax.inject.Inject

/**
 * Use case for fetching general item details by item ID.
 *
 * @param itemRepository The repository to access item data.
 */
class GetProductDetailsByIdGeneralUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsResponseModel =
        itemRepository.getProductDetailsByIdGeneral(params.productId)
            ?: throw Exception("Product not found") // TODO Handle case

    /**
     * Parameters for fetching general item details.
     *
     * @param productId The ID of the item to retrieve details for.
     */
    data class Params(
        val productId: Int
    )
}