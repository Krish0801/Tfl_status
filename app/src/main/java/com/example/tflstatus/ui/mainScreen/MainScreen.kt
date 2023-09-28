package com.example.tflstatus.ui.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tflstatus.data.model.TflStatusModelItemModel

@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val tflStatusList by viewModel.tflStatus.collectAsState()

    StatusPage(tflStatusList)
}

@Composable
fun StatusPage(tflStatusList: List<TflStatusModelItemModel>) {
    val backgroundcolor = Color(0xFFF7F7F8)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundcolor)
    ) {
        StatusList(tflStatusList)
    }
}

@Composable
fun StatusList(tflStatusList: List<TflStatusModelItemModel>) {
    val textColor = Color(0xFF000000)
    val cardColor = Color(0xFFFFFFFF)
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(tflStatusList) { index, tflStatus ->
            Card(
                elevation = 2.dp,
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .border(4.dp, color = tflLineColor(tflStatus.name.toString()), shape =RoundedCornerShape(1.dp) )
            ) {
                Column(
                    modifier = Modifier
                        .background(color = cardColor)
                        .padding(24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = tflStatus.name.toString(),
                            color = textColor,
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = tflStatus.lineStatuses?.get(0)?.statusSeverityDescription.toString(),
                            color = getStatusTextColor(tflStatus),
                            textAlign = TextAlign.Right,
                            fontStyle= FontStyle.Normal ,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun getStatusTextColor(tflStatus: TflStatusModelItemModel): Color {
    return when (tflStatus.lineStatuses?.get(0)?.statusSeverityDescription.toString()) {
        "Good Service" -> Color.Green
        "Minor Delays" -> Color.Black
        else -> Color.Red
    }
}

fun tflLineColor(lineName: String): Color {
    return when (lineName.lowercase()) {
        "bakerloo" -> Color(0xFF894E24)
        "central" -> Color(0xFFDC241F)
        "circle" -> Color(0xFFFFCE00)
        "district" -> Color(0xFF007D32)
        "hammersmith & city" -> Color(0xFFD799AF)
        "jubilee" -> Color(0xFF53565A)
        "metropolitan" -> Color(0xFF9B0058)
        "northern" -> Color(0xFF000000)
        "piccadilly" -> Color(0xFF0018A8)
        "victoria" -> Color(0xFF00A0E2)
        "waterloo & city" -> Color(0xFF6AB9DA)
        else -> Color.Gray
    }
}
