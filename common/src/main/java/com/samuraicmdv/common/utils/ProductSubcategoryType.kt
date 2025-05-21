package com.samuraicmdv.common.utils

import com.samuraicmdv.common.R

enum class ProductSubcategoryType {
    /**
     * Category: CABLE
     */
    CHARGE_CABLE,
    DATA_CABLE,
    AUXILIARY_CABLE,
    ADAPTER_CABLE,

    /**
     * Category: CASE
     */
    ARMBAND_CASE,
    EARPHONE_CASE,
    PHONE_CASE,
    SMART_BAND_CASE,
    TABLET_CASE,
    WATER_CASE,

    /**
     * Category: CHARGER
     */
    CAR_CHARGER_ADAPTER,
    CAR_CHARGER_KIT,
    POWER_BANK_CHARGER,
    WALL_CHARGER_ADAPTER,
    WALL_CHARGER_KIT,
    WIRELESS_CHARGER,

    /**
     * Category: EARPHONE
     */
    WIRED_EARPHONE,
    WIRELESS_EARPHONE,

    /**
     * Category: HEADPHONE
     */
    WIRED_HEADPHONE,
    WIRELESS_HEADPHONE,

    /**
     * Category: HOLDER
     */
    CAR_HOLDER,
    DESKTOP_HOLDER,
    RING_HOLDER,
    STICK_HOLDER,

    /**
     * Category: INFORMATICS
     */
    HEADSET,
    KEYBOARD,
    KEYBOARD_MOUSE_KIT,
    MOUSE,
    MOUSE_PAD,

    /**
     * Category: PROTECTOR
     */
    CABLE_PROTECTOR,
    CHARGER_PROTECTOR,
    SCREEN_PROTECTOR,
    CAMERA_PROTECTOR,

    /**
     * Category: STORAGE
     */
    PEN_DRIVE,
    SD,

    /**
     * Category: WATCH
     */
    SMART_BAND,
    SMART_WATCH,

    UNKNOWN
}

fun ProductSubcategoryType?.getNameResId(): Int =
    when (this) {
        ProductSubcategoryType.CHARGE_CABLE -> R.string.product_subcategory_charge_cable_name
        ProductSubcategoryType.DATA_CABLE -> R.string.product_subcategory_data_cable_name
        ProductSubcategoryType.AUXILIARY_CABLE -> R.string.product_subcategory_auxiliary_cable_name
        ProductSubcategoryType.ADAPTER_CABLE -> R.string.product_subcategory_adapter_cable_name
        ProductSubcategoryType.ARMBAND_CASE -> R.string.product_subcategory_armband_case_name
        ProductSubcategoryType.EARPHONE_CASE -> R.string.product_subcategory_earphone_case_name
        ProductSubcategoryType.PHONE_CASE -> R.string.product_subcategory_phone_case_name
        ProductSubcategoryType.SMART_BAND_CASE -> R.string.product_subcategory_smart_band_case_name
        ProductSubcategoryType.TABLET_CASE -> R.string.product_subcategory_tablet_case_name
        ProductSubcategoryType.WATER_CASE -> R.string.product_subcategory_water_case_name
        ProductSubcategoryType.CAR_CHARGER_ADAPTER -> R.string.product_subcategory_car_charger_adapter_name
        ProductSubcategoryType.CAR_CHARGER_KIT -> R.string.product_subcategory_car_charger_kit_name
        ProductSubcategoryType.POWER_BANK_CHARGER -> R.string.product_subcategory_power_bank_charger_name
        ProductSubcategoryType.WALL_CHARGER_ADAPTER -> R.string.product_subcategory_wall_charger_adapter_name
        ProductSubcategoryType.WALL_CHARGER_KIT -> R.string.product_subcategory_wall_charger_kit_name
        ProductSubcategoryType.WIRELESS_CHARGER -> R.string.product_subcategory_wireless_charger_name
        ProductSubcategoryType.WIRED_EARPHONE -> R.string.product_subcategory_wired_earphone_name
        ProductSubcategoryType.WIRELESS_EARPHONE -> R.string.product_subcategory_wireless_earphone_name
        ProductSubcategoryType.WIRED_HEADPHONE -> R.string.product_subcategory_wired_headphone_name
        ProductSubcategoryType.WIRELESS_HEADPHONE -> R.string.product_subcategory_wireless_headphone_name
        ProductSubcategoryType.CAR_HOLDER -> R.string.product_subcategory_car_holder_name
        ProductSubcategoryType.DESKTOP_HOLDER -> R.string.product_subcategory_desktop_holder_name
        ProductSubcategoryType.RING_HOLDER -> R.string.product_subcategory_ring_holder_name
        ProductSubcategoryType.STICK_HOLDER -> R.string.product_subcategory_stick_holder_name
        ProductSubcategoryType.HEADSET -> R.string.product_subcategory_headset_name
        ProductSubcategoryType.KEYBOARD -> R.string.product_subcategory_keyboard_name
        ProductSubcategoryType.KEYBOARD_MOUSE_KIT -> R.string.product_subcategory_keyboard_mouse_kit_name
        ProductSubcategoryType.MOUSE -> R.string.product_subcategory_mouse_name
        ProductSubcategoryType.MOUSE_PAD -> R.string.product_subcategory_mouse_pad_name
        ProductSubcategoryType.CABLE_PROTECTOR -> R.string.product_subcategory_cable_protector_name
        ProductSubcategoryType.CHARGER_PROTECTOR -> R.string.product_subcategory_charger_protector_name
        ProductSubcategoryType.SCREEN_PROTECTOR -> R.string.product_subcategory_screen_protector_name
        ProductSubcategoryType.CAMERA_PROTECTOR -> R.string.product_subcategory_camera_protector_name
        ProductSubcategoryType.PEN_DRIVE -> R.string.product_subcategory_pen_drive_name
        ProductSubcategoryType.SD -> R.string.product_subcategory_sd_name
        ProductSubcategoryType.SMART_BAND -> R.string.product_subcategory_smart_band_name
        ProductSubcategoryType.SMART_WATCH -> R.string.product_subcategory_smart_watch_name
        else -> R.string.product_subcategory_unknown_name
    }

fun ProductSubcategoryType?.getIconResId(): Int =
    when (this) {
        ProductSubcategoryType.ADAPTER_CABLE -> R.drawable.product_subcategory_adapter_cable_icon
        ProductSubcategoryType.ARMBAND_CASE -> R.drawable.product_subcategory_armband_case_icon
        ProductSubcategoryType.AUXILIARY_CABLE -> R.drawable.product_subcategory_auxiliary_cable_icon
        ProductSubcategoryType.CABLE_PROTECTOR -> R.drawable.product_subcategory_cable_protector_icon
        ProductSubcategoryType.CAMERA_PROTECTOR -> R.drawable.product_subcategory_camera_protector_icon
        ProductSubcategoryType.CAR_CHARGER_ADAPTER -> R.drawable.product_subcategory_car_adapter_charger_icon
        ProductSubcategoryType.CAR_HOLDER -> R.drawable.product_subcategory_car_holder_icon
        ProductSubcategoryType.CAR_CHARGER_KIT -> R.drawable.product_subcategory_car_charger_kit_icon
        ProductSubcategoryType.CHARGE_CABLE -> R.drawable.product_subcategory_charge_cable_icon
        ProductSubcategoryType.CHARGER_PROTECTOR -> R.drawable.product_subcategory_charger_protector_icon
        ProductSubcategoryType.DATA_CABLE -> R.drawable.product_subcategory_data_cable_icon
        ProductSubcategoryType.DESKTOP_HOLDER -> R.drawable.product_subcategory_desktop_holder_icon
        ProductSubcategoryType.EARPHONE_CASE -> R.drawable.product_subcategory_earphone_case_icon
        ProductSubcategoryType.HEADSET -> R.drawable.product_subcategory_headset_icon
        ProductSubcategoryType.KEYBOARD -> R.drawable.product_subcategory_keyboard_icon
        ProductSubcategoryType.KEYBOARD_MOUSE_KIT -> R.drawable.product_subcategory_keyboard_mouse_kit_icon
        ProductSubcategoryType.MOUSE -> R.drawable.product_subcategory_mouse_icon
        ProductSubcategoryType.MOUSE_PAD -> R.drawable.product_subcategory_mouse_pad_icon
        ProductSubcategoryType.PEN_DRIVE -> R.drawable.product_subcategory_pen_drive_icon
        ProductSubcategoryType.PHONE_CASE -> R.drawable.product_subcategory_phone_case_icon
        ProductSubcategoryType.POWER_BANK_CHARGER -> R.drawable.product_subcategory_power_bank_charger_icon
        ProductSubcategoryType.RING_HOLDER -> R.drawable.product_subcategory_ring_holder_icon
        ProductSubcategoryType.SD -> R.drawable.product_subcategory_sd_icon
        ProductSubcategoryType.SCREEN_PROTECTOR -> R.drawable.product_subcategory_screen_protector_icon
        ProductSubcategoryType.SMART_BAND -> R.drawable.product_subcategory_smart_band_icon
        ProductSubcategoryType.SMART_BAND_CASE -> R.drawable.product_subcategory_smart_band_case_icon
        ProductSubcategoryType.SMART_WATCH -> R.drawable.product_subcategory_smart_watch_icon
        ProductSubcategoryType.STICK_HOLDER -> R.drawable.product_subcategory_stick_holder_icon
        ProductSubcategoryType.TABLET_CASE -> R.drawable.product_subcategory_tablet_case_icon
        ProductSubcategoryType.WALL_CHARGER_ADAPTER -> R.drawable.product_subcategory_wall_adapter_charger_icon
        ProductSubcategoryType.WALL_CHARGER_KIT -> R.drawable.product_subcategory_wall_kit_charger_icon
        ProductSubcategoryType.WATER_CASE -> R.drawable.product_subcategory_water_case_icon
        ProductSubcategoryType.WIRED_EARPHONE -> R.drawable.product_subcategory_wired_earphone_icon
        ProductSubcategoryType.WIRED_HEADPHONE -> R.drawable.product_subcategory_wired_headphone_icon
        ProductSubcategoryType.WIRELESS_CHARGER -> R.drawable.product_subcategory_wireless_charger_icon
        ProductSubcategoryType.WIRELESS_EARPHONE -> R.drawable.product_subcategory_wireless_earphone_icon
        ProductSubcategoryType.WIRELESS_HEADPHONE -> R.drawable.product_subcategory_wireless_headphone_icon
        else -> R.drawable.product_category_unknown_icon
    }