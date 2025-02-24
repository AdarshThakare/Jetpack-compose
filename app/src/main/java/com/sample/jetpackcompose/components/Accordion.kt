package com.sample.jetpackcompose.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpandableCard () {
    var expandableState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (!expandableState) 180f else 0f
    )
    Card (modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth()
        .animateContentSize(animationSpec = tween(durationMillis = 300 , easing = LinearOutSlowInEasing)),
        shape = RoundedCornerShape(6.dp),
        onClick = { expandableState = !expandableState}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "What's Lorem Ipsum ?",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(7f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    onClick = { expandableState = !expandableState },
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, "Up Arrow")
                }
            }
            if (expandableState) {
                Text(
                    "lorem ipsum dolor sit amet, consectetur adipiscing elit dolor sit amet, consectetur ".repeat(5),
                    fontSize = 14.sp,
                    maxLines = 5,
                    lineHeight = 24.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp,bottom = 16.dp).width(300.dp),
                    textAlign = TextAlign.Center,

                )
            }
        }
    }
}

//@Preview
//@Composable
//fun AccordionPreview(){
//    ExpandableCard()
//}