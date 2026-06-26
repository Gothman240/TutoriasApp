package com.example.tutoriasapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutoriasapp.ui.screens.LoginScreen

@Composable
fun NavigationWrap(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login){
        composable<Login>{
//            LoginScreen(navigateToSelectRole = { navController.navigate(SelectRoleScreen()) })
        }
        composable<Home>{
//            Home(navController)
        }
    }
}