package com.samuraicmdv.featureproductdetails.event

/**
 * Represents the events that can be triggered in the item details screen and that are handled by the presentation
 * layer.
 */
sealed class ProductDetailsPresentationEvent : ProductDetailsEvent {
    /**
     * Event triggered when the user wants to edit the item.
     */
    data object EditProduct : ProductDetailsPresentationEvent()

    /**
     * Event triggered when the user wants to cancel the item edition.
     */
    data object CancelProductEdition : ProductDetailsPresentationEvent()

    /**
     * Exit the screen.
     */
    data object ExitScreen : ProductDetailsPresentationEvent()

}