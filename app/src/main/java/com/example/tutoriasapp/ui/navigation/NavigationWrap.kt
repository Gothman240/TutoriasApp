package com.example.tutoriasapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutoriasapp.ui.screens.HomeScreen
import com.example.tutoriasapp.ui.screens.LoginScreen
import com.example.tutoriasapp.ui.screens.MainScreen
import com.example.tutoriasapp.ui.screens.SelectRoleScreen
import com.example.tutoriasapp.ui.screens.SelectUniversity
import com.example.tutoriasapp.ui.screens.SubjectSelectorScreen

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
            SelectRoleScreen(
                navigateToSelectUniversity = { navController.navigate(SelectUniversity)}
            )
        }
        composable<SelectUniversity> {
            SelectUniversity(
                navigateSelectSubjectScreen = { navController.navigate((SelectSubject)) }
            )
        }
        composable<SelectSubject> {
            SubjectSelectorScreen(
                onSelectionComplete = { navController.navigate((MainScreen))}
            )
        }
        composable<MainScreen>{
            MainScreen()
        }

    }
}