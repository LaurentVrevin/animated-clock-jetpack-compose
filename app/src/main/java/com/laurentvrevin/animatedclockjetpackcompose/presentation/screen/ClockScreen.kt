package com.laurentvrevin.animatedclockjetpackcompose.presentation.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ClockScreen(modifier: Modifier = Modifier) {

    var totalMinutes by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            totalMinutes++
        }
    }

    // Calculate hours and minutes from total minutes
    val hours = (totalMinutes / 60) % 12
    val minutes = totalMinutes % 60

    // Calculate rotation angles for hands
    val minuteRotation = (minutes / 60f) * 360f
    val hourRotation = (hours / 12f) * 360f + (minuteRotation / 12f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                // Gradient background
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFa2d2ff),
                        Color(0xFFfdf0d5),
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(16.dp))
            // Counter Text
            Text(
                text = "%02d:%02d".format(hours, minutes),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color(0xFFfdf0d5),
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp
            )
            Spacer(modifier = Modifier.padding(36.dp))

            // Clock
            Box(
                modifier = Modifier
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier
                        .size(300.dp)
                        .border(8.dp, color = Color(0xFFff8fab), shape = CircleShape)
                        .background(Color(0xffffe5ec), shape = CircleShape)
                ) {
                    val middle = Offset(size.minDimension / 2, size.minDimension / 2)
                    val radius = size.minDimension / 2

                    // Minutes
                    withTransform(
                        {
                            rotate(minuteRotation, middle)
                        }, {
                            drawLine(
                                strokeWidth = 6.dp.toPx(),
                                cap = StrokeCap.Round,
                                color = Color(0xFFffafcc),
                                start = middle,
                                end = Offset(
                                    x = middle.x,
                                    y = middle.y - radius * 0.8f
                                )
                            )
                        }
                    )

                    // Hours
                    withTransform(
                        {
                            rotate(hourRotation, middle)
                        }, {
                            drawLine(
                                strokeWidth = 8.dp.toPx(),
                                cap = StrokeCap.Round,
                                color = Color(0xFFcdb4db),
                                start = middle,
                                end = Offset(
                                    x = middle.x,
                                    y = middle.y - radius * 0.65f
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ClockScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ClockScreen()
    }
}
