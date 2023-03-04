package com.example.unsplashdemo2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.example.unsplashdemo2.screens.home.HomeScreen

@OptIn(ExperimentalPagingApi::class)
@Composable
fun SetUpNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
    }
}