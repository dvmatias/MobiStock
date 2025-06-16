package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.repository.ItemRepository
import javax.inject.Inject

/**
 * Use case for fetching item details by item code for a specific store.
 *
 * @param itemRepository The repository to access item data.
 */
class GetProductDetailsByCodeForStoreUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsResponseModel =
        itemRepository.getProductDetailsByCodeForStore(
            params.productCode,
            params.storeId
        ) ?: throw Exception("Product not found") // TODO Handle case

    /**
     * Parameters for fetching item details for a specific store.
     *
     * @param productCode The code of the item to retrieve details for.
     * @param storeId The ID of the store for which to retrieve item details.
     */
    data class Params(
        val productCode: String,
        val storeId: Int,
    )
}