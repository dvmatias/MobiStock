package com.samuraicmdv.featureproductcategory.event

sealed class CategoryPresentationEvent : CategoryEvent {
    data class FilterProductsByBrand(val brandId: Int) : CategoryPresentationEvent()
    data class SortProducts(val productsSort: ProductsSort) : CategoryPresentationEvent()
    data class HandleProductDetailsBottomSheetState(val show: Boolean, val productId: Int = -1) : CategoryPresentationEvent()
}

data class ProductsSort(
    val name: ProductsSortName,
    val type: ProductsSortType,
)

enum class ProductsSortName {
    BY_NAME_ALPHABETICALLY,
    BY_COST_PRICE_AMOUNT,
    BY_SELLING_PRICE_AMOUNT,
}

enum class ProductsSortType {
    ASCENDING,
    DESCENDING
}

