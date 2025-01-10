package com.laurentvrevin.animatedclockjetpackcompose.presentation.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ClockScreen(modifier: Modifier = Modifier){
    val infiniteTransition = rememberInfiniteTransition(label = "")


    val minHeightWidth: Dp = 80.dp


    val minutesRotation by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 1F,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        ), label = ""
    )


    val hourRotation by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 1F,
        animationSpec = infiniteRepeatable(
            animation = tween(86400000, easing = LinearEasing)
        ), label = ""
    )




    val minutes = (minutesRotation * 60).toInt()
    val hours = (hourRotation * 12).toInt()




    Column (modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "%02d:%02d".format(hours, minutes),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
        )




        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Canvas(
                modifier = Modifier
                    .size(300.dp)
                    .border(2.dp, color = Color.Black, shape = CircleShape)
                    .background(Color.White, shape = CircleShape)
            ) {
                val middle = Offset(size.minDimension / 2, size.minDimension / 2)
                withTransform(
                    {
                        rotate(360f * minutesRotation, middle)
                    }, {
                        drawLine(
                            strokeWidth = 6.dp.toPx(),
                            cap = StrokeCap.Round,
                            color = Color.Red,
                            start = middle,
                            end = Offset(
                                size.minDimension / 2,
                                (minHeightWidth / 2 - 20.dp).toPx()
                            )
                        )
                    }
                )
                withTransform(
                    {
                        rotate(360f * hourRotation, middle)
                    }, {
                        drawLine(
                            strokeWidth = 6.dp.toPx(),
                            cap = StrokeCap.Round,
                            color = Color.Black,
                            start = middle,
                            end = Offset(
                                size.minDimension / 2,
                                (minHeightWidth / 2 - 12.dp).toPx()
                            )
                        )
                    }
                )
            }
        }
    }
}
@Preview
@Composable
fun ClockScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ClockScreen()
        }
}