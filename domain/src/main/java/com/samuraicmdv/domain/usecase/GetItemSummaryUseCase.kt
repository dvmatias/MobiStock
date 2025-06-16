package com.samuraicmdv.domain.usecase

import com.samuraicmdv.domain.model.ItemSummaryResponseModel
import com.samuraicmdv.domain.repository.ItemRepository
import javax.inject.Inject

/**
 * Use case for fetching general item details by item code.
 *
 * @param itemRepository The repository to access item data.
 */
class GetItemSummaryUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(params: Params): ItemSummaryResponseModel =
        itemRepository.getItemSummary(params.itemId, params.itemCode, params.storeId)
            ?: throw Exception("Product not found") // TODO Handle case

    /**
     * Parameters for fetching general item details.
     *
     * @param itemId The ID of the item to retrieve details for.
     * @param itemCode The code of the item to retrieve details for.
     * @param storeId The ID of the store for which to retrieve item details.
     */
    data class Params(
        val itemId: Int? = null,
        val itemCode: String? = null,
        val storeId: Int? = null
    )
}