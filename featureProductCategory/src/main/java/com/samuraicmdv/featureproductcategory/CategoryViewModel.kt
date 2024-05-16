package com.samuraicmdv.featureproductcategory

import androidx.lifecycle.ViewModel
import com.samuraicmdv.featureproductcategory.state.CategoryScreenState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel(assistedFactory = CategoryViewModel.Factory::class)
class CategoryViewModel @AssistedInject constructor(
    @Assisted private val categoryId: Int
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoryScreenState(isLoading = true))
    val uiState: StateFlow<CategoryScreenState> = _uiState.asStateFlow()

    @AssistedFactory
    interface Factory {
        fun create(categoryId: Int): CategoryViewModel
    }
}