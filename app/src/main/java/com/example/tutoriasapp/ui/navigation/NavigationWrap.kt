package com.example.tutoriasapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutoriasapp.ui.screens.LoginScreen
import com.example.tutoriasapp.ui.screens.SelectRoleScreen

@Composable
fun NavigationWrap(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login){
        composable<Login>{
            LoginScreen(
                onLoginSuccess = { navController.navigate(SelectRole) }
            )
        }
        composable<SelectRole>{
            SelectRoleScreen()
        }

    }
}