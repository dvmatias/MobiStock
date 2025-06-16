package com.samuraicmdv.featureproductdetails.event

import com.samuraicmdv.common.uidata.ProductUiData

sealed class ProductDetailsBusinessEvent : ProductDetailsEvent {
    /**
     * Event triggered when the user wants to see a item details.
     */
    class ViewProductDetails(val productId: Int) : ProductDetailsBusinessEvent()

    /**
     * Event triggered when the user wants to create a new item.
     */
    class CreateNewProduct(val product: ProductUiData) : ProductDetailsBusinessEvent()
}