package com.sample.jetpackcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sample.jetpackcompose.Screen
import com.sample.jetpackcompose.components.ExpandableCard
import com.sample.jetpackcompose.components.PasswordField

@Composable
fun ScreenB(
    navController : NavHostController
){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        ExpandableCard()
        PasswordField()
        Button(onClick = {navController.navigate(Screen.ScreenA.route){
            popUpTo(Screen.ScreenA.route){
                inclusive = true
            }
        } }, modifier = Modifier.padding(8.dp)){
            Text(text = "Switch to A")
        }
    }
}