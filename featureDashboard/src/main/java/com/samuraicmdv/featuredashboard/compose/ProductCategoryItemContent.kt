package com.samuraicmdv.featuredashboard.compose

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.event.DashboardNavigationEvent
import com.samuraicmdv.ui.R
import com.samuraicmdv.ui.util.ThemePreviews
import com.samuraicmdv.common.R as CommonR

val iconSizeCategory = 42.dp
val iconSizeSubCategory = 36.dp

/**
 * Composable function that displays a product category item with an icon, name, and optional expand button.
 */
@Composable
fun ProductCategoryItemContent(
    iconDrawable: Drawable?,
    id: Int,
    name: String?,
    isCategory: Boolean,
    showExpandButton: Boolean,
    isExpanded: Boolean,
    onExpandButtonClick: () -> Unit = {},
    handleEvent: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(MobiTheme.dimens.dimen_1),
        colors = if (isCategory) {
            CardDefaults.cardColors(
                containerColor = CardDefaults.cardColors().containerColor
            )
        } else {
            CardDefaults.cardColors(
                containerColor = MobiTheme.colors.surfaceContainer
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    handleEvent(DashboardNavigationEvent.NavigateProductCategory(id))
                }
                .padding(if (isCategory) MobiTheme.dimens.dimen_1 else MobiTheme.dimens.dimen_0_5)

        ) {
            iconDrawable?.let {
                Image(
                    painter = rememberDrawablePainter(it),
                    contentDescription = null,
                    modifier = Modifier
                        .size(if (isCategory) iconSizeCategory else iconSizeSubCategory)
                )
            }
            name?.let {
                Text(
                    text = it,
                    maxLines = 1,
                    style = MobiTheme.typography.bodyMedium,
                    color = MobiTheme.colors.textPrimary,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = MobiTheme.dimens.dimen_1)
                        .align(Alignment.CenterVertically)
                )
            }
            if (showExpandButton) {
                IconButton(
                    onClick = {
                        onExpandButtonClick()
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        painter = rememberDrawablePainter(
                            AppCompatResources.getDrawable(
                                context,
                                if (isExpanded) R.drawable.ic_arrow_up_24px else R.drawable.ic_arrow_down_24px
                            )
                        ),
                        tint = MobiTheme.colors.primary,
                        contentDescription = "Dropdown Icon",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(6.dp),
                    )
                }
            }
        }
    }

}

@ThemePreviews
@Composable
fun PreviewProductCategoryItemContent_Category() {
    MobiTheme {
        ProductCategoryItemContent(
            iconDrawable = AppCompatResources.getDrawable(
                LocalContext.current,
                CommonR.drawable.product_category_battery_icon
            ),
            id = 1,
            name = "Batteries",
            isCategory = true,
            showExpandButton = true,
            isExpanded = false,
            onExpandButtonClick = {},
            handleEvent = {}
        )
    }
}

@ThemePreviews
@Composable
fun PreviewProductCategoryItemContent_Subcategory() {
    MobiTheme {
        ProductCategoryItemContent(
            iconDrawable = AppCompatResources.getDrawable(
                LocalContext.current,
                CommonR.drawable.product_category_battery_icon
            ),
            id = 1,
            name = "Batteries",
            isCategory = false,
            showExpandButton = false,
            isExpanded = false,
            onExpandButtonClick = {},
            handleEvent = {}
        )
    }
}