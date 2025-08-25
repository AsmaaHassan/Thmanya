package com.example.thmanya.ui.home.components

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by AsmaaHassan on 25,August,2025
 * Trufla Technology,
 * Cairo, Egypt.
 */
@Serializable
enum class LayoutType {
    @SerialName("queue")
    QUEUE,

    @SerialName("big_square")
    BIG_SQUARE,

    @SerialName("2_lines_grid")
    TWO_LINES_GRID,

    // Fallback for new or unexpected values
    UNKNOWN
}