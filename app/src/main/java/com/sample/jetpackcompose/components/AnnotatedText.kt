package com.sample.jetpackcompose.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.jetpackcompose.ui.theme.gblue
import com.sample.jetpackcompose.ui.theme.ggreen
import com.sample.jetpackcompose.ui.theme.gred
import com.sample.jetpackcompose.ui.theme.gyellow

@Composable
fun CustomText (){
    SelectionContainer{

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background). padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = gblue,
                        fontSize = 20.sp,
                        fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append('G')
                }
                withStyle(
                    style = SpanStyle(
                        color = gred,
                        fontSize = 20.sp,
                        fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append('o')
                }
                withStyle(
                    style = SpanStyle(
                        color = gyellow,
                        fontSize = 20.sp,
                        fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append('o')
                }
                withStyle(
                    style = SpanStyle(
                        color = ggreen,
                        fontSize = 20.sp,
                        fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append('g')
                }
                withStyle(
                    style = SpanStyle(
                        color = gblue,
                        fontSize = 20.sp,
                        fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append('l')
                }
                withStyle(
                    style = SpanStyle(
                        color = gred,
                        fontSize = 20.sp,
                        fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append('e')
                }
            }
        )
        Text(
            text = "Adarsh".repeat(20),
            modifier = Modifier.width(150.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
            DisableSelection {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "Hellow  World!",
                    fontWeight = FontWeight.Bold,
                )
            }

    }
    }
}

//@Preview
//@Composable
//fun CustomTextPreview(){
//    CustomText()
//}