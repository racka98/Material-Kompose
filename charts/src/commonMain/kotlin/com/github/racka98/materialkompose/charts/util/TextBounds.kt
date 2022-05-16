package com.github.racka98.materialkompose.charts.util

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Paint

/**
 * Computes the correct compose textBounds for desktop and Android with the
 * respective APIs
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect fun Paint.getTextBounds(
    text: String,
    start: Int,
    end: Int,
    bounds: Rect,
    textSize: Float
): Rect