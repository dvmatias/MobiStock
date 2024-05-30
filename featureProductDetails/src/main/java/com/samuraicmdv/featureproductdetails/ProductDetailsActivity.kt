package com.samuraicmdv.featureproductdetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.samuraicmdv.common.BUNDLE_KEY_IS_EDIT_MODE
import com.samuraicmdv.common.BUNDLE_KEY_PRODUCT_ID
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductdetails.compose.ProductDetailsScreen
import com.samuraicmdv.ui.util.ThemePreviews

class ProductDetailsActivity : ComponentActivity() {
    /**
     * The ID of the product to display details for or edit. If this param is not provided in the Intent, the screen
     * will show an error message.
     */
    private val productId: Int
        get() = intent.getIntExtra(BUNDLE_KEY_PRODUCT_ID, -1)

    /**
     * Whether the screen is in edit mode or not. Default value is false, if this param is not provided in the Intent,
     * the screen will present a view mode for product details.
     */
    private val isEditMode: Boolean
        get() = intent.getBooleanExtra(BUNDLE_KEY_IS_EDIT_MODE, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobiTheme {
                Surface {
                    ProductDetailsScreen(
                        isEditMode = isEditMode
                    )
                }
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsScreen(modifier: Modifier = Modifier) {
    MobiTheme {
        Surface {
            ProductDetailsScreen(isEditMode = true)
        }
    }
}