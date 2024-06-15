package com.samuraicmdv.common.event

data class Action(
    val name: String,
    val label: String,
    val handler: (Any) -> Any
)