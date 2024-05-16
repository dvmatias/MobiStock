package com.samuraicmdv.featureproductcategory

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = CategoryViewModel.Factory::class)
class CategoryViewModel @AssistedInject constructor(
    @Assisted private val categoryId: Int
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(categoryId: Int): CategoryViewModel
    }
}