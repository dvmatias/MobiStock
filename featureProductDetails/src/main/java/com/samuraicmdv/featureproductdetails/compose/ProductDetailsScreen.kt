package com.samuraicmdv.featureproductdetails.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.EMPTY_STRING
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.R
import com.samuraicmdv.featureproductdetails.event.ProductDetailsEvent
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiMode.CREATE
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiMode.CREATE_SUCCESS
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiMode.EDIT
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiMode.VIEW
import com.samuraicmdv.featureproductdetails.state.ProductDetailsUiState
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    uiState: ProductDetailsUiState,
    handleEvent: (ProductDetailsEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val isScreenLoading = uiState.isLoading
    val screenMode = uiState.screenMode
    val product = uiState.product

    if (isScreenLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else
        Scaffold(
            topBar = {
                if (screenMode != CREATE_SUCCESS) { // Hide the top app bar in case of create success
                    Surface(
                        shadowElevation = 0.dp // Added in case I want to have a bottom shadow in the top app bar
                    ) {
                        TopAppBar(
                            title = {
                                val title =
                                    when (screenMode) {
                                        VIEW -> EMPTY_STRING
                                        EDIT -> stringResource(id = R.string.title_app_bar_edit)
                                        CREATE -> EMPTY_STRING
                                        CREATE_SUCCESS -> EMPTY_STRING
                                    }
                                Text(
                                    text = title,
                                    style = MobiTheme.typography.titleLargeBold
                                )
                            },
                            navigationIcon = {
                                IconButton(
                                    onClick = { /* TODO Handle navigation icon click */ }
                                ) {
                                    Icon(
                                        Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = null,
                                        tint = MobiTheme.colors.primary
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MobiTheme.colors.background
                            )
                        )
                    }
                }
            }
        ) { paddingValues ->
            when (screenMode) {
                VIEW -> ProductDetailsScreenContentView(
                    product,
                    modifier.padding(paddingValues)
                )
                EDIT,
                CREATE -> ProductDetailsScreenContentEdit(
                    product = product,
                    categories = uiState.categories,
                    brands = uiState.brands,
                    handleEvent = handleEvent,
                    modifier = modifier.padding(paddingValues),
                )
                CREATE_SUCCESS -> ProductDetailsScreenCreateSuccessView(
                    productId = product?.id,
                    handleEvent = handleEvent,
                    modifier = modifier.padding(paddingValues),
                )
            }
        }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenEdit() {
    MobiTheme {
        Surface {
            ProductDetailsScreen(
                uiState = ProductDetailsUiState(
                    screenMode = CREATE
                ),
                handleEvent = {},
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreenView() {
    MobiTheme {
        Surface {
            ProductDetailsScreen(
                uiState = ProductDetailsUiState(
                    screenMode = CREATE_SUCCESS
                ),
                handleEvent = {},
            )
        }
    }
}