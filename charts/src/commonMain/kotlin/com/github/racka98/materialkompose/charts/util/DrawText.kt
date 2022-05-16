package com.github.racka98.materialkompose.charts.util

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint

@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect fun Canvas.drawTextHelper(
    text: String,
    x: Float,
    y: Float,
    paint: Paint,
    textSize: Float
)