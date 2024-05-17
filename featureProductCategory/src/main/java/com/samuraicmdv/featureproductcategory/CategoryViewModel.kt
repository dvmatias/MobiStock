package com.samuraicmdv.featureproductcategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuraicmdv.domain.usecase.GetCategoryUseCase
import com.samuraicmdv.featureproductcategory.state.CategoryScreenState
import com.samuraicmdv.featureproductcategory.transformer.CategoryUiDataTransformer
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel(assistedFactory = CategoryViewModel.Factory::class)
class CategoryViewModel @AssistedInject constructor(
    @Assisted("storeId") private val storeId: Int,
    @Assisted("categoryId") private val categoryId: Int,
    private val getCategoryUseCase: GetCategoryUseCase,
    private val categoryTransformer: CategoryUiDataTransformer
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoryScreenState(isLoading = true))
    val uiState: StateFlow<CategoryScreenState> = _uiState.asStateFlow()

    init {
        getCategory(storeId, categoryId)
    }

    private fun getCategory(storeId: Int, categoryId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            withContext(Dispatchers.IO) {
                getCategoryUseCase(storeId, categoryId)
            }.let { result ->
                categoryTransformer.transform(result)
            }.run {
                _uiState.value = this.copy(isLoading = false)
            }

        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("storeId") storeId: Int,
            @Assisted("categoryId") categoryId: Int
        ): CategoryViewModel
    }
}