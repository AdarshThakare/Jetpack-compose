package com.sample.jetpackcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sample.jetpackcompose.Screen
import com.sample.jetpackcompose.components.CustomText
import com.sample.jetpackcompose.components.GoogleButton

@Composable
fun ScreenA(
    navController: NavHostController
){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        GoogleButton()
        Spacer(modifier = Modifier.height(10.dp))
        CustomText()
        Button(onClick = {
            navController.navigate(Screen.ScreenB.route)
        }, modifier = Modifier.padding(8.dp)){
            Text(text = "Switch to B")
        }
    }
}