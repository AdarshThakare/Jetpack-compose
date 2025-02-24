package com.sample.jetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sample.jetpackcompose.screens.ScreenA
import com.sample.jetpackcompose.screens.ScreenB

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
  NavHost(navController = navController ,  startDestination = Screen.ScreenA.route){
      composable(Screen.ScreenA.route){
          ScreenA(navController = navController)
      }
      composable(Screen.ScreenB.route){
          ScreenB(navController = navController)
      }

  }
}