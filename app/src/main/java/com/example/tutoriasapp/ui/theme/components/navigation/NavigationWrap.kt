package com.example.tutoriasapp.ui.theme.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrap(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login){
        composable<Login>{
//            Login(navController)
        }
        composable<Home>{
//            Home(navController)
        }
    }
}