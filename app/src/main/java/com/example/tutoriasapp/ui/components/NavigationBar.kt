package com.example.tutoriasapp.ui.components

import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class BottomBarTab(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomBarTab("home_tab", "Inicio", Icons.Default.Home)
    object Classes : BottomBarTab("classes_tab", "Mis Tutorías", Icons.Default.DateRange)
    object Profile : BottomBarTab("profile_tab", "Perfil", Icons.Default.Person)
}

@Composable
fun NavigationBar(navController: NavController) {

    val tabs = listOf(
        BottomBarTab.Home,
        BottomBarTab.Classes,
        BottomBarTab.Profile
    )

    NavigationBar(
        // Le aplicamos esquinas redondeadas arriba para un look premium
        modifier = Modifier.clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        // Monitorea la ruta actual del subNavController
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        tabs.forEach { tab ->
            val isSelected = currentRoute == tab.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (currentRoute != tab.route) {
                        navController.navigate(tab.route) {
                            // Evita acumular pantallas repetidas si el usuario cliquea muchas veces
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.title
                    )
                },
                label = {
                    Text(
                        text = tab.title,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    // El óvalo contenedor del ícono seleccionado (azul ultra suave de tu paleta)
                    indicatorColor = Color(0xFFEEF2FA),
                    // Colores de los elementos activos (Tu azul #0C56D1)
                    selectedIconColor = Color(0xFF0C56D1),
                    selectedTextColor = Color(0xFF0C56D1),
                    // Colores de los elementos inactivos
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}

