package com.sample.jetpackcompose

sealed class Screen (val route: String) {
    object ScreenA : Screen(route = "screen_a")
    object ScreenB : Screen(route = "screen_b")
}