package com.samuraicmdv.featureproductcategory.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featureproductcategory.event.CategoryEvent
import com.samuraicmdv.featureproductcategory.event.CategoryPresentationEvent.HandleProductDetailsBottomSheetState
import com.samuraicmdv.ui.util.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ProductDetailsBottomSheet(
    showBottomSheet: Boolean,
    handleEvent: (CategoryEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    LaunchedEffect(key1 = showBottomSheet) {
        if (showBottomSheet) sheetState.show()
        else sheetState.hide()
    }

    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == SheetValue.Expanded &&
            sheetState.targetValue == SheetValue.PartiallyExpanded
        )
            sheetState.hide()
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                handleEvent(HandleProductDetailsBottomSheetState(show = false))
            },
            dragHandle = { BottomSheetDefaults.DragHandle() },
            modifier = modifier.padding(top = 48.dp)
        ) {
            ProductDetailsBottomSheetContent()
        }
    }
}

@Composable
fun ProductDetailsBottomSheetContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
    }
}

@ThemePreviews
@Composable
fun PreviewProductDetailsBottomSheetContent() {
    MobiTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProductDetailsBottomSheetContent()
        }
    }
}

/*

var sheetState by rememberSaveable { mutableStateOf(CartBottomSheetState.Collapsed) }
val cartItems = remember { mutableStateListOf(*SampleItems.take(2).toTypedArray()) }
BoxWithConstraints(
Modifier.fillMaxSize()
) {
    CartBottomSheet(
        modifier = Modifier.align(Alignment.BottomEnd),
        items = cartItems,
        sheetState = sheetState,
        maxHeight = maxHeight,
        maxWidth = maxWidth,
        onRemoveItemFromCart = {
            cartItems.removeAt(it)
        },
        onSheetStateChange = {
            sheetState = it
        }
    )
}

}

enum class CartBottomSheetState {
    Collapsed,
    Expanded,
    Hidden,
}

data class ExpandedCartItem(
    val idx: Int,
    val visible: MutableTransitionState<Boolean> = MutableTransitionState(true),
    val data: ItemData
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CartBottomSheet(
    modifier: Modifier = Modifier,
    items: List<ItemData> = SampleItems.take(14),
    maxHeight: Dp,
    maxWidth: Dp,
    sheetState: CartBottomSheetState = CartBottomSheetState.Collapsed,
    onRemoveItemFromCart: (Int) -> Unit = {},
    onSheetStateChange: (CartBottomSheetState) -> Unit = {}
) {
    val expandedCartItems by remember(items) {
        derivedStateOf {
            items.mapIndexed { idx, it -> ExpandedCartItem(idx = idx, data = it) }
        }
    }

    LaunchedEffect(expandedCartItems) {
        snapshotFlow {
            expandedCartItems.firstOrNull {
                it.visible.isIdle && !it.visible.targetState
            }
        }.collect {
            if (it != null) {
                onRemoveItemFromCart(it.idx)
            }
        }
    }

    val cartTransition = updateTransition(
        targetState = sheetState,
        label = "cartTransition"
    )

    val cartXOffset by cartTransition.animateDp(
        label = "cartXOffset",
        transitionSpec = {
            when {
                CartBottomSheetState.Expanded isTransitioningTo CartBottomSheetState.Collapsed ->
                    tween(durationMillis = 433, delayMillis = 67)

                CartBottomSheetState.Collapsed isTransitioningTo CartBottomSheetState.Expanded ->
                    tween(durationMillis = 150)

                else ->
                    tween(durationMillis = 450)
            }
        }
    ) {
        when (it) {
            CartBottomSheetState.Expanded -> 0.dp
            CartBottomSheetState.Hidden -> maxWidth
            else -> {
                val size = min(3, items.size)
                var width = 24 + 40 * (size + 1) + 16 * size + 16
                if (items.size > 3) width += 32 + 16
                maxWidth - width.dp
            }
        }
    }

    val cartHeight by cartTransition.animateDp(
        label = "cartHeight",
        transitionSpec = {
            when {
                CartBottomSheetState.Expanded isTransitioningTo CartBottomSheetState.Collapsed ->
                    tween(durationMillis = 283)

                else ->
                    tween(durationMillis = 500)
            }
        }
    ) {
        if (it == CartBottomSheetState.Expanded) maxHeight else 56.dp
    }

    val cornerSize by cartTransition.animateDp(
        label = "cartCornerSize",
        transitionSpec = {
            when {
                CartBottomSheetState.Expanded isTransitioningTo CartBottomSheetState.Collapsed ->
                    tween(durationMillis = 433, delayMillis = 67)

                else ->
                    tween(durationMillis = 150)
            }
        }
    ) {
        if (it == CartBottomSheetState.Expanded) 0.dp else 24.dp
    }

    Surface(
        modifier = modifier
            .width(maxWidth)
            .height(cartHeight)
            .offset { IntOffset(cartXOffset.roundToPx(), 0) },
        shape = RoundedCornerShape(topStart = cornerSize),
        color = MobiTheme.colors.primary,
    ) {
        Box {
            cartTransition.AnimatedContent(
                transitionSpec = {
                    when {
                        CartBottomSheetState.Expanded isTransitioningTo CartBottomSheetState.Collapsed ->
                            fadeIn(
                                animationSpec = tween(
                                    durationMillis = 117,
                                    delayMillis = 117,
                                    easing = LinearEasing
                                )
                            ) togetherWith
                                    fadeOut(animationSpec = tween(durationMillis = 117, easing = LinearEasing))

                        CartBottomSheetState.Collapsed isTransitioningTo CartBottomSheetState.Expanded ->
                            fadeIn(
                                animationSpec = tween(
                                    durationMillis = 150,
                                    delayMillis = 150,
                                    easing = LinearEasing
                                )
                            ) togetherWith
                                    fadeOut(animationSpec = tween(durationMillis = 150, easing = LinearEasing))

                        else -> EnterTransition.None togetherWith ExitTransition.None
                    }.using(SizeTransform(clip = false))
                },
            ) { targetState ->
                if (targetState == CartBottomSheetState.Expanded) {
                    ExpandedCart(
                        cartItems = expandedCartItems,
                        onRemoveItem = {
                            it.visible.targetState = false
                        },
                        onCollapse = {
                            onSheetStateChange(CartBottomSheetState.Collapsed)
                        }
                    )
                } else {
                    CollapsedCart(
                        items = items,
                        onTap = {
                            onSheetStateChange(CartBottomSheetState.Expanded)
                        }
                    )
                }
            }
            cartTransition.AnimatedVisibility(
                modifier = Modifier.align(Alignment.BottomCenter),
                visible = { it == CartBottomSheetState.Expanded },
                enter = fadeIn(animationSpec = tween(durationMillis = 150, delayMillis = 150, easing = LinearEasing)) +
                        scaleIn(
                            animationSpec = tween(
                                durationMillis = 250,
                                delayMillis = 250,
                                easing = LinearOutSlowInEasing
                            ), initialScale = 0.8f
                        ),
                exit = fadeOut(animationSpec = tween(durationMillis = 117, easing = LinearEasing)) +
                        scaleOut(
                            animationSpec = tween(durationMillis = 100, easing = FastOutLinearInEasing),
                            targetScale = 0.8f
                        )
            ) {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun ExpandedCart(
    cartItems: List<ExpandedCartItem>,
    onRemoveItem: (ExpandedCartItem) -> Unit = {},
    onCollapse: () -> Unit = {}
) {
    Surface(
        color = MobiTheme.colors.secondary
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = 64.dp)
        ) {
            item {
                CartHeader(
                    cartSize = cartItems.size,
                    onCollapse = onCollapse
                )
            }
            itemsIndexed(
                items = cartItems,
                key = { idx, item -> "$idx-${item.data.id}" }
            ) { _, it ->
                AnimatedVisibility(
                    visibleState = it.visible,
                    exit = fadeOut() + slideOut(targetOffset = { IntOffset(x = -it.width / 2, y = 0) })
                ) {
                    CartItem(
                        item = it.data,
                        onRemoveAction = { onRemoveItem(it) }
                    )
                }
            }
        }
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
fun ExpandedCartPreview() {
    MobiTheme {
        ExpandedCart(SampleItems.mapIndexed { idx, it -> ExpandedCartItem(idx = idx, data = it) })
    }
}

@Composable
private fun CartHeader(cartSize: Int, onCollapse: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onCollapse() },
            Modifier.padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Collapse cart icon"
            )
        }
        Text(
            "Cart".uppercase(),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(Modifier.width(12.dp))
        Text("$cartSize items".uppercase())
    }
}

@Preview(name = "Cart header")
@Composable
fun CartHeaderPreview() {
    MobiTheme {
        Surface(
            Modifier.fillMaxWidth(),
            color = MobiTheme.colors.secondary
        ) {
            CartHeader(cartSize = 15, onCollapse = {})
        }
    }
}

@Composable
private fun CartItem(
    modifier: Modifier = Modifier,
    item: ItemData,
    onRemoveAction: () -> Unit = {}
) {
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onRemoveAction() },
            Modifier.padding(horizontal = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Remove item icon"
            )
        }
        Column(
            Modifier.fillMaxWidth()
        ) {
            Divider(color = MobiTheme.colors.onSecondary.copy(alpha = 0.3f))
            Row(
                Modifier.padding(vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.photoResId),
                    contentDescription = "Image for: ${item.title}",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(Modifier.width(20.dp))
                Column(
                    Modifier.padding(end = 16.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${item.vendor}".uppercase(),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                        Text(
                            text = "$${item.price}",
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}

@Preview(name = "Cart item")
@Composable
fun CartItemPreview() {
    MobiTheme {
        Surface(color = MobiTheme.colors.secondary) {
            CartItem(item = SampleItems[0])
        }
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
fun CartBottomSheetPreview() {
    MobiTheme {
        BoxWithConstraints(
            Modifier.fillMaxSize()
        ) {
            var sheetState by remember { mutableStateOf(CartBottomSheetState.Collapsed) }

            Button(
                onClick = {
                    if (sheetState == CartBottomSheetState.Collapsed) {
                        sheetState = CartBottomSheetState.Hidden
                    } else {
                        sheetState = CartBottomSheetState.Collapsed
                    }
                }
            ) {
                Text("Toggle BottomSheet")
            }

            CartBottomSheet(
                modifier = Modifier.align(Alignment.BottomEnd),
                sheetState = sheetState,
                maxHeight = maxHeight,
                maxWidth = maxWidth
            ) {
                sheetState = it
            }
        }
    }
}

@Composable
private fun CollapsedCart(
    items: List<ItemData> = SampleItems.take(6),
    onTap: () -> Unit = {}
) {
    Row(
        Modifier
            .clickable { onTap() }
            .padding(start = 24.dp, top = 8.dp, bottom = 8.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Shopping cart icon",
            )
        }
        items.take(3).forEach { item ->
            CollapsedCartItem(data = item)
        }
        if (items.size > 3) {
            Box(
                Modifier.size(width = 32.dp, height = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "+${items.size - 3}",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun CollapsedCartItem(data: ItemData) {
    Image(
        painter = painterResource(id = data.photoResId),
        contentDescription = data.title,
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}

@ThemePreviews
@Composable
fun CollapsedCartPreview() {
    MobiTheme {
        Surface {
            CollapsedCart()
        }
    }
}

data class ItemData(
    val id: Int,
    val title: String,
    val price: Int,
    val vendor: Vendor,
    val category: Category,
    val photoResId: Int,
    val isPhotoPortrait: Boolean = false
)

enum class Vendor {
    Alphi,
    Lmbrjk,
    Mal,
    Six,
    Squiggle,
}

fun getVendorResId(vendor: Vendor): Int {
    when (vendor) {
        Vendor.Alphi -> {
            return R.drawable.logo_1
        }

        Vendor.Lmbrjk -> {
            return R.drawable.logo_1
        }

        Vendor.Mal -> {
            return R.drawable.logo_1
        }

        Vendor.Six -> {
            return R.drawable.logo_1
        }

        else -> {
            return R.drawable.logo_1
        }
    }
}

enum class Category {
    All,
    Accessories,
    Clothing,
    Home
}

val SampleItems = listOf(
    ItemData(
        id = 0,
        title = "Vagabond sack",
        price = 120,
        vendor = Vendor.Squiggle,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 1,
        title = "Stella sunglasses",
        price = 58,
        vendor = Vendor.Mal,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 2,
        title = "Whitney belt",
        price = 35,
        vendor = Vendor.Lmbrjk,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 3,
        title = "Garden stand",
        price = 98,
        vendor = Vendor.Alphi,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 4,
        title = "Strut earrings",
        price = 34,
        vendor = Vendor.Six,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 5,
        title = "Varsity socks",
        price = 12,
        vendor = Vendor.Lmbrjk,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 6,
        title = "Weave key ring",
        price = 16,
        vendor = Vendor.Six,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 7,
        title = "Gatsby hat",
        price = 40,
        vendor = Vendor.Six,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 8,
        title = "Shrug bag",
        price = 198,
        vendor = Vendor.Squiggle,
        category = Category.Accessories,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 9,
        title = "Gilt desk trio",
        price = 58,
        vendor = Vendor.Alphi,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 10,
        title = "Copper wire rack",
        price = 18,
        vendor = Vendor.Alphi,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 11,
        title = "Soothe ceramic set",
        price = 28,
        vendor = Vendor.Mal,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 12,
        title = "Hurrahs tea set",
        price = 34,
        vendor = Vendor.Six,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 13,
        title = "Blue stone mug",
        price = 18,
        vendor = Vendor.Mal,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 14,
        title = "Rainwater tray",
        price = 27,
        vendor = Vendor.Six,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 15,
        title = "Chambray napkins",
        price = 16,
        vendor = Vendor.Six,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 16,
        title = "Succulent planters",
        price = 16,
        vendor = Vendor.Alphi,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 17,
        title = "Quartet table",
        price = 175,
        vendor = Vendor.Squiggle,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 18,
        title = "Kitchen quattro",
        price = 129,
        vendor = Vendor.Alphi,
        category = Category.Home,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 19,
        title = "Clay sweater",
        price = 48,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 20,
        title = "Sea tunic",
        price = 45,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic
    ),
    ItemData(
        id = 21,
        title = "Plaster tunic",
        price = 38,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 22,
        title = "White pinstripe shirt",
        price = 70,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 23,
        title = "Chambray shirt",
        price = 70,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
    ),
    ItemData(
        id = 24,
        title = "Seabreeze sweater",
        price = 60,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 25,
        title = "Gentry jacket",
        price = 178,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
    ),
    ItemData(
        id = 26,
        title = "Navy trousers",
        price = 74,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 27,
        title = "Walter henley white",
        price = 38,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 28,
        title = "Surf and perf shirt",
        price = 48,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
    ),
    ItemData(
        id = 29,
        title = "Ginger scarf",
        price = 98,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
    ),
    ItemData(
        id = 30,
        title = "Ramona crossover",
        price = 68,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 31,
        title = "Chambray shirt",
        price = 38,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
    ),
    ItemData(
        id = 32,
        title = "Class white collar",
        price = 58,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 33,
        title = "Cerise scallop tee",
        price = 42,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
    ),
    ItemData(
        id = 34,
        title = "Shoulder rolls tee",
        price = 27,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 35,
        title = "Grey slouch tank",
        price = 24,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 36,
        title = "Sunshirt dress",
        price = 58,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
    ItemData(
        id = 37,
        title = "Fine lines tee",
        price = 58,
        vendor = Vendor.Lmbrjk,
        category = Category.Clothing,
        photoResId = R.drawable.in_stock_ic,
        isPhotoPortrait = true
    ),
)
*/
