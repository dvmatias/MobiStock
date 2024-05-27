package com.samuraicmdv.featurecategory.event

import com.samuraicmdv.featurecategory.state.ProductUiData

sealed class CategoryPresentationEvent : CategoryEvent {
    data class FilterProductsByBrand(val brandId: Int) : CategoryPresentationEvent()

    data class SortProducts(val productsSort: ProductsSort) : CategoryPresentationEvent()

    data class HandleProductDetailsBottomSheetState(val show: Boolean, val product: ProductUiData? = null) :
        CategoryPresentationEvent()

    data class OnCategoryTitleAlphaChange(val categoryTitleAlpha: Float) : CategoryPresentationEvent()

    data class OnStickyHeaderPinned(val isHeaderPinned: Boolean) : CategoryPresentationEvent()
}

data class ProductsSort(
    val name: ProductsSortName,
    val type: ProductsSortType,
)

enum class ProductsSortName {
    BY_NAME_ALPHABETICALLY,
    BY_SELLING_PRICE_AMOUNT,
}

enum class ProductsSortType {
    ASCENDING,
    DESCENDING
}

