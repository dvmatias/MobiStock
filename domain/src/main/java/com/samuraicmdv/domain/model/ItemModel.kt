package com.samuraicmdv.domain.model

sealed class ItemModel {
    data class Summary(
        val id: Int? = null,
        val name: String? = null,
        val code: String? = null,
        val model: String? = null,
        val description: String? = null,
        val price: Double? = null,
        val thumbnailUrl: String? = null,
        val brandName: String? = null,
        val brandLogoUrl: String? = null,
        val categoryName: String? = null,
        val subcategoryName: String? = null,
        val stock: Int? = null,
    ): ItemModel()

    data class Details(
        val id: Int? = null
    ): ItemModel()
}