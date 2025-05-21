package com.samuraicmdv.common.utils

import com.samuraicmdv.common.R

enum class ProductCategoryType {
    UNKNOWN,
    BATTERY,
    CABLE,
    CASE,
    CHARGER,
    EARPHONE,
    GAME,
    HEADPHONE,
    HOLDER,
    HOME,
    INFORMATICS,
    LIGHT,
    MICROPHONE,
    PROTECTOR,
    SPEAKER,
    STORAGE,
    STRAP,
    TRIPOD,
    WATCH,
    OTHER,
}

fun ProductCategoryType?.getNameResId(): Int =
    when (this) {
        ProductCategoryType.UNKNOWN -> R.string.product_category_unknown_name
        ProductCategoryType.BATTERY -> R.string.product_category_battery_name
        ProductCategoryType.CABLE -> R.string.product_category_cable_name
        ProductCategoryType.CASE -> R.string.product_category_case_name
        ProductCategoryType.CHARGER -> R.string.product_category_charger_name
        ProductCategoryType.EARPHONE -> R.string.product_category_earphone_name
        ProductCategoryType.GAME -> R.string.product_category_game_name
        ProductCategoryType.HEADPHONE -> R.string.product_category_headphone_name
        ProductCategoryType.HOLDER -> R.string.product_category_holder_name
        ProductCategoryType.HOME -> R.string.product_category_home_name
        ProductCategoryType.INFORMATICS -> R.string.product_category_informatics_name
        ProductCategoryType.LIGHT -> R.string.product_category_light_name
        ProductCategoryType.MICROPHONE -> R.string.product_category_microphone_name
        ProductCategoryType.PROTECTOR -> R.string.product_category_protector_name
        ProductCategoryType.SPEAKER -> R.string.product_category_speaker_name
        ProductCategoryType.STORAGE -> R.string.product_category_storage_name
        ProductCategoryType.STRAP -> R.string.product_category_strap_name
        ProductCategoryType.TRIPOD -> R.string.product_category_tripod_name
        ProductCategoryType.WATCH -> R.string.product_category_watch_name
        ProductCategoryType.OTHER -> R.string.product_category_other_name
        null -> R.string.product_category_unknown_name
    }


fun ProductCategoryType?.getIconResId(): Int =
    when (this) {
        ProductCategoryType.UNKNOWN -> R.drawable.product_category_unknown_icon
        ProductCategoryType.BATTERY -> R.drawable.product_category_battery_icon
        ProductCategoryType.CABLE -> R.drawable.product_category_cable_icon
        ProductCategoryType.CASE -> R.drawable.product_category_case_icon
        ProductCategoryType.CHARGER -> R.drawable.product_category_charger_icon
        ProductCategoryType.EARPHONE -> R.drawable.product_category_earphone_icon
        ProductCategoryType.GAME -> R.drawable.product_category_game_icon
        ProductCategoryType.HEADPHONE -> R.drawable.product_category_headphone_icon
        ProductCategoryType.HOLDER -> R.drawable.product_category_holder_icon
        ProductCategoryType.HOME -> R.drawable.product_category_unknown_icon
        ProductCategoryType.INFORMATICS -> R.drawable.product_category_informatics_icon
        ProductCategoryType.LIGHT -> R.drawable.product_category_light_icon
        ProductCategoryType.MICROPHONE -> R.drawable.product_category_microphone_icon
        ProductCategoryType.PROTECTOR -> R.drawable.product_category_protector_icon
        ProductCategoryType.SPEAKER -> R.drawable.product_category_speaker_icon
        ProductCategoryType.STORAGE -> R.drawable.product_category_storage_icon
        ProductCategoryType.STRAP -> R.drawable.product_category_strap_icon
        ProductCategoryType.TRIPOD -> R.drawable.product_category_tripod_icon
        ProductCategoryType.WATCH -> R.drawable.product_category_watch_icon
        ProductCategoryType.OTHER -> R.drawable.product_category_unknown_icon
        null -> R.drawable.product_category_unknown_icon
    }