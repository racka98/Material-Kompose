package com.github.racka98.materialkompose.charts.barChart.renderer.bar

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.github.racka98.materialkompose.charts.barChart.BarChartData

interface BarDrawer {
    fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar,
        selected: Boolean = false,
        selectedBarColor: Color
    )
}