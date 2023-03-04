package com.example.unsplashdemo2.navigation

sealed class Screen(val route: String){
    object Home: Screen("home_screen")
    object Search: Screen("search_screen")
}