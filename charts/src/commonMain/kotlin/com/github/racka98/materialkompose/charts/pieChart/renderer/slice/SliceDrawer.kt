package com.github.racka98.materialkompose.charts.pieChart.renderer.slice

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.github.racka98.materialkompose.charts.pieChart.PieChartData

interface SliceDrawer {
    fun drawSlice(
        drawScope: DrawScope,
        canvas: Canvas,
        area: Size,
        startAngle: Float,
        sweepAngle: Float,
        slice: PieChartData.Slice
    )
}