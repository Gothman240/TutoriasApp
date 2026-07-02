package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutoriasapp.R
import com.example.tutoriasapp.ui.components.NavigationBar
import com.example.tutoriasapp.ui.components.TutorCard

data class Tutor(
    val name: String,
    val faculty: String,
    val rating: Double,
    val pricePerHour: Double,
    val subjects: List<String>,
    val isTop: Boolean = false
)
@Composable
fun HomeScreen(){
    val profesoresFrecuentes = listOf(
        Tutor(
            name = "Carlos Mendoza",
            faculty = "Facultad de Ciencias Exactas",
            rating = 4.9,
            pricePerHour = 25.00,
            subjects = listOf("Cálculo II", "Física I"),
            isTop = true
        ),
        Tutor(
            name = "Lucía Fernández",
            faculty = "Facultad de Ingeniería",
            rating = 4.8,
            pricePerHour = 22.50,
            subjects = listOf("Programación", "Álgebra"),
            isTop = true
        ),
        Tutor(
            name = "Martín Gómez",
            faculty = "Facultad de Ciencias Económicas",
            rating = 4.5,
            pricePerHour = 18.00,
            subjects = listOf("Economía General", "Estadística"),
            isTop = false
        ),
        Tutor(
            name = "Elena Rossi",
            faculty = "Facultad de Derecho",
            rating = 4.7,
            pricePerHour = 20.00,
            subjects = listOf("Introducción al Derecho"),
            isTop = false
        )
    )

    val categorias = listOf("Todos", "Matemática", "Física", "Química", "Programación")
    var categoriaSeleccionada by remember { mutableStateOf("Todos") }
    var searchQuery by remember { mutableStateOf("") }



        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAFAFA)),
            contentPadding = PaddingValues()
        ) {

            // 1. PANEL SUPERIOR: Saludo y Foto de Perfil


            // 2. ESPACIO PARA TU BARRA DE BÚSQUEDA
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 2.dp)
                ) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 18.dp),
                        placeholder = {
                            Text(
                                text = "Buscar tu universidad...",
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = Color(0xFF0C56D1)
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF0C56D1),
                            unfocusedBorderColor = Color.LightGray,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                    )
                }
            }

            // 3. CHIPS / BULLETS DE CATEGORÍAS (Scroll Horizontal)
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp), // Margen en los extremos del scroll
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categorias) { categoria ->
                        val esSeleccionada = categoria == categoriaSeleccionada

                        FilterChip(
                            selected = esSeleccionada,
                            onClick = { categoriaSeleccionada = categoria },
                            label = {
                                Text(
                                    text = categoria,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontWeight = if (esSeleccionada) FontWeight.Bold else FontWeight.Normal
                                    )
                                )
                            },
                            shape = RoundedCornerShape(14.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = Color.White,
                                selectedContainerColor = Color(8,91,204), // Tu azul cuando está activo
                                selectedLabelColor = Color.White,
                                labelColor = Color.DarkGray
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = esSeleccionada,
                                borderColor = Color.LightGray.copy(alpha = 0.5f),
                                selectedBorderColor = Color.Transparent,
                                borderWidth = 1.dp
                            )
                        )
                    }
                }
            }

            // Título intermedio antes de los tutores
            item {
                Text(
                    text = "Tutores destacados",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 8.dp)
                )
            }

            // 4. LISTA DE TUTORES (Contenido dinámico que ya tenías)
            items(profesoresFrecuentes) { tutor ->
                TutorCard(
                    tutor = tutor,
                    onReservarClick = { /* Lógica para ir al calendario */ },
                    modifier = Modifier.padding(horizontal = 4.dp) // Ajuste fino de margen
                )
            }
        }
    }



@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}