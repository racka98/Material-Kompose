package com.github.racka98.materialkompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.racka98.materialkompose.charts.barChart.BarChart
import com.github.racka98.materialkompose.charts.barChart.BarChartData
import com.github.racka98.materialkompose.charts.barChart.BarChartOptions
import com.github.racka98.materialkompose.charts.barChart.renderer.label.SimpleValueDrawer
import com.github.racka98.materialkompose.charts.barChart.renderer.xaxis.SimpleXAxisDrawer
import com.github.racka98.materialkompose.charts.barChart.renderer.yaxis.SimpleYAxisDrawer
import com.github.racka98.materialkompose.charts.pieChart.PieChart
import com.github.racka98.materialkompose.charts.pieChart.PieChartData
import com.github.racka98.materialkompose.charts.pieChart.renderer.slice.SimpleSliceDrawer
import com.github.racka98.materialkompose.charts.pieChart.renderer.text.SimpleTextDrawer
import com.github.racka98.materialkompose.data.TestData

@Composable
fun ChartsPreview() {
    val barColor = MaterialTheme.colorScheme.secondary

    val data = remember { TestData.data }
    val barChartData = remember {
        derivedStateOf {
            val tempList = mutableListOf<BarChartData.Bar>()
            data.forEach { entry ->
                tempList.add(
                    BarChartData.Bar(
                        value = entry.value.toFloat(),
                        color = barColor,
                        label = entry.label,
                        uniqueId = entry.uniqueId
                    )
                )
            }
            tempList.toList()
        }
    }

    val pieChartData = remember {
        derivedStateOf {
            val tempList = mutableListOf<PieChartData.Slice>()
            data.forEach { entry ->
                tempList.add(
                    PieChartData.Slice(
                        value = entry.value.toFloat(),
                        color = getRandomColor()
                    )
                )
            }
            tempList.toList()
        }
    }

    val selectedBar = rememberSaveable(barChartData.value) {
        mutableStateOf(barChartData.value.first().uniqueId)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            MyBarChart(
                data = barChartData.value,
                selectedBarId = selectedBar.value,
                onBarClicked = { selectedBar.value = it }
            )
        }

        item { MyPieChart(data = pieChartData.value) }
    }
}

@Composable
private fun MyBarChart(
    data: List<BarChartData.Bar>,
    selectedBarId: Int,
    onBarClicked: (id: Int) -> Unit
) {
    BarChart(
        barChartData = BarChartData(bars = data),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(180.dp),
        selectedUniqueId = selectedBarId,
        selectedBarColor = MaterialTheme.colorScheme.primary,
        onBarClicked = {
            onBarClicked(it)
        },
        xAxisDrawer = SimpleXAxisDrawer(
            axisLineColor = MaterialTheme.colorScheme.onBackground
                .copy(alpha = 0.5f)
        ),
        yAxisDrawer = SimpleYAxisDrawer(
            labelValueFormatter = { value -> value.toInt().toString() },
            labelTextColor = MaterialTheme.colorScheme.onBackground
                .copy(alpha = 0.5f),
            axisLineColor = MaterialTheme.colorScheme.onBackground
                .copy(alpha = 0.5f)
        ),
        labelDrawer = SimpleValueDrawer(
            labelTextColor = MaterialTheme.colorScheme.onBackground
                .copy(alpha = 0.5f)
        ),
        barChartOptions = BarChartOptions().apply {
            barsSpacingFactor = 0.05f
            showIntervalLines = true
            showYAxisLabels = false
        }
    )
}

@Composable
private fun MyPieChart(
    data: List<PieChartData.Slice>
) {
    PieChart(
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp),
        pieChartData = PieChartData(
            slices = data,
            spacingBy = 0.05f
        ),
        sliceDrawer = SimpleSliceDrawer(
            sliceThickness = 20f
        ),
        centerTextDrawer = SimpleTextDrawer(
            labelTextSize = 16.sp,
            labelTextColor = MaterialTheme.colorScheme.onBackground
        ),
        centerText = "Data Pie",
        onCenterClick = { }
    )
}

private fun getRandomColor(): Color {
    val colors = listOf(
        Color.Blue, Color.Yellow, Color.Cyan, Color.Red,
        Color.Green, Color.Magenta, Color.LightGray, Color.Gray
    )
    return colors.random()
}