package com.samuraicmdv.featureproductdetails.event

import com.samuraicmdv.featureproductdetails.data.ProductUiData

sealed class ProductDetailsBusinessEvent : ProductDetailsEvent {
    /**
     * Event triggered when the user wants to see a product details.
     */
    class ViewProductDetails(val productId: Int) : ProductDetailsBusinessEvent()

    /**
     * Event triggered when the user wants to create a new product.
     */
    class CreateNewProduct(val product: ProductUiData) : ProductDetailsBusinessEvent()
}