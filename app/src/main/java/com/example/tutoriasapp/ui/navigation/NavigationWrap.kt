package com.example.tutoriasapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutoriasapp.ui.screens.DateTimePurchaseScreen
import com.example.tutoriasapp.ui.screens.LoginScreen
import com.example.tutoriasapp.ui.screens.MainScreen
import com.example.tutoriasapp.ui.screens.PurchaseSummaryScreen
import com.example.tutoriasapp.ui.screens.SelectMajorScreen
import com.example.tutoriasapp.ui.screens.SelectRoleScreen
import com.example.tutoriasapp.ui.screens.SelectUniversity
import com.example.tutoriasapp.ui.screens.SubjectSelectorScreen
import com.example.tutoriasapp.ui.screens.SuccessPurchaseScreen
import com.example.tutoriasapp.ui.screens.TutorProfileScreen

@Composable
fun NavigationWrap() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                onLoginSuccess = { navController.navigate(SelectRole) }
            )
        }
        composable<SelectRole> {
            SelectRoleScreen(
                navigateToSelectUniversity = { navController.navigate(SelectUniversity) }
            )
        }
        composable<SelectUniversity> {
            SelectUniversity(
                navigateSelectMajorScreen = { navController.navigate((SelectMajor)) }
            )
        }
        composable<SelectMajor> {
            SelectMajorScreen(
                navigateSelectSubjectScreen = { navController.navigate((SelectSubject))}
            )
        }
        composable<SelectSubject> {
            SubjectSelectorScreen(
                onSelectionComplete = { navController.navigate((MainScreen)) }
            )
        }
        composable<MainScreen> {
            MainScreen(rootNavController = navController)
        }
        composable("tutor_profile") {
            TutorProfileScreen(onNavigateToDateTime = { navController.navigate("date_time_purchase") })
        }
        composable("date_time_purchase") {
            DateTimePurchaseScreen(onNavigateToSummary = { navController.navigate("purchase_summary") })
        }
        composable("purchase_summary") {
            PurchaseSummaryScreen(
                onNavigateToSuccess = { navController.navigate("success_purchase") }
            )
        }
        composable("success_purchase") {
            SuccessPurchaseScreen(onNavigateToMainScreen = { navController.navigate(MainScreen) })
        }
    }
}