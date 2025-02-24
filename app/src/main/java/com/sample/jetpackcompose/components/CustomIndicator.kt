package com.sample.jetpackcompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomIndicator(
    canvasSize : Dp = 300.dp,
    indicatorValue : Int = 0,
    maxIndicatorValue : Int = 100,
    backgroundIndicatorColor : Color  = Color.LightGray,
    backgroundIndicatorStrokeWidth : Float = 100f,
    foregroundIndicatorColor : Color = MaterialTheme.colorScheme.primary,
    foregroundIndicatorStrokeWidth : Float = 100f,
    bigTextFontSize : TextUnit =46.sp,
    bigTextColor : Color = MaterialTheme.colorScheme.primary,
    bigTextSuffix : String = "GB",
    smallText : String = "Remaining",
    smallTextFontSize : TextUnit = MaterialTheme.typography.headlineSmall.fontSize,
    smallTextColor : Color = MaterialTheme.colorScheme.primary
){
    var allowedIndicatorValue by remember {
        mutableStateOf(maxIndicatorValue)
    }

    allowedIndicatorValue = if(indicatorValue <= maxIndicatorValue) indicatorValue else maxIndicatorValue
    var animatedIndicatorValue by remember{
        mutableStateOf(0f)
    }
    LaunchedEffect(key1 = allowedIndicatorValue){
        animatedIndicatorValue = allowedIndicatorValue.toFloat()
    }

    val percentage = (animatedIndicatorValue/ maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    val receivedValue by animateIntAsState(
        targetValue = allowedIndicatorValue,
        animationSpec = tween(1000)
    )
    
    Column (modifier= Modifier.size(canvasSize).background(MaterialTheme.colorScheme.background)
        .drawBehind {
            val componentSize = size/1.25f
            backgroundIndicator(
                componentSize = componentSize,
                componentColor = backgroundIndicatorColor,
                indicatorStrokeWidth = backgroundIndicatorStrokeWidth,
            )
            foregroundIndicator(
                sweepAngle = sweepAngle,
                componentSize = componentSize,
                componentColor = foregroundIndicatorColor,
                indicatorStrokeWidth = foregroundIndicatorStrokeWidth
            )
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        EmbeddedElements(
            bigText = receivedValue,
            bigTextFontSize = bigTextFontSize,
            bigTextColor = bigTextColor,
            bigTextSuffix = bigTextSuffix,
            smallText = smallText,
            smallTextFontSize = smallTextFontSize,
            smallTextColor = smallTextColor
        )
    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    componentColor : Color,
    indicatorStrokeWidth : Float
) {
    drawArc(
        size = componentSize,
        color = componentColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle : Float,
    componentSize: Size,
    componentColor : Color,
    indicatorStrokeWidth : Float
) {
    drawArc(
        size = componentSize,
        color = componentColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

@Composable
fun EmbeddedElements(
    bigText : Int,
    bigTextFontSize : TextUnit,
    bigTextColor : Color,
    bigTextSuffix : String,
    smallText : String,
    smallTextFontSize : TextUnit,
    smallTextColor : Color
){
    Text(
        text = smallText,
        fontSize = smallTextFontSize,
        color = smallTextColor,
        textAlign = TextAlign.Center
    )
    Text(
        text = "$bigText ${bigTextSuffix.take(2)}",
        fontSize = bigTextFontSize,
        color = bigTextColor,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.ExtraBold
    )
}

@Preview
@Composable
fun CustomIndicatorPreview(){
    CustomIndicator()
}