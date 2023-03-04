package com.example.unsplashdemo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.example.unsplashdemo2.navigation.SetUpNavGraph
import com.example.unsplashdemo2.ui.theme.UnsplashDemo2Theme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplashDemo2Theme() {
                val navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}