package com.samuraicmdv.featuredashboard.transformer

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.samuraicmdv.common.utils.getIconResId
import com.samuraicmdv.common.utils.getNameResId
import com.samuraicmdv.domain.model.GetCategoriesResponseModel
import com.samuraicmdv.featuredashboard.state.ProductCategoriesState
import com.samuraicmdv.featuredashboard.state.ProductCategoryUiData
import com.samuraicmdv.featuredashboard.state.ProductSubcategoryUiData
import javax.inject.Inject

class CategoriesUiDataTransformerImpl @Inject constructor(
    private val context: Context
) : CategoriesUiDataTransformer {

    override fun transform(model: GetCategoriesResponseModel): ProductCategoriesState {
        val categories = model.productCategories?.map { category ->
                ProductCategoryUiData(
                    id = category.id ?: -1,
                    name = context.getString(category.type.getNameResId()),
                    iconDrawable = AppCompatResources.getDrawable(context, category.type.getIconResId()),
                    productsQuantity = category.productsQuantity ?: 0,
                    subcategories = category.subcategories?.map { subcategory ->
                        ProductSubcategoryUiData(
                            id = subcategory.id ?: -1,
                            name = context.getString(subcategory.type.getNameResId()),
                            iconDrawable = AppCompatResources.getDrawable(context, subcategory.type.getIconResId()),
                            productsQuantity = 0
                        )
                    }
                )
            }.orEmpty()

        return ProductCategoriesState(
            categories = categories,
            isLoading = false
        )
    }

}
