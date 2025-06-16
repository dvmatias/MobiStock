package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ProductDetailsResponseModel
import com.samuraicmdv.domain.repository.ItemRepository
import javax.inject.Inject

/**
 * Use case for fetching item details for a specific store by item ID.
 *
 * @param itemRepository The repository to access item data.
 */
class GetProductDetailsByIdForStoreUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(params: Params): ProductDetailsResponseModel =
       TODO()

    /**
     * Parameters for fetching item details for a specific store.
     *
     * @param productId The ID of the item to retrieve details for.
     * @param storeId The ID of the store for which to retrieve item details.
     */
    data class Params(
        val productId: Int,
        val storeId: Int,
    )
}