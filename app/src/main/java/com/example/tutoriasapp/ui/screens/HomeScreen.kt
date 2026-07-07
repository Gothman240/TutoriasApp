package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutoriasapp.R
import com.example.tutoriasapp.ui.components.TutorCard

data class Tutor(
    val name: String,
    val faculty: String,
    val rating: String,
    val image: Painter,
    val pricePerHour: Double,
    val subjects: List<String>,
    val isTop: Boolean = false
)
@Composable
fun HomeScreen(onNavigateToProfile: () -> Unit) {
    val profesoresFrecuentes = listOf(
        Tutor(
            name = "Alejandro Ruiz",
            faculty = "Universidad Nacional de La Matanza",
            rating = "4.9",
            image = painterResource(R.drawable.alejandro),
            pricePerHour = 4.500,
            subjects = listOf("Cálculo II", "Física I"),
            isTop = true
        ),
        Tutor(
            name = "Lucía Fernández",
            faculty = "Universidad Nacional de La Matanza",
            rating = "4.8",
            image = painterResource(R.drawable.lucia),
            pricePerHour = 3.500,
            subjects = listOf("Programación", "Álgebra"),
            isTop = true
        ),
        Tutor(
            name = "Martín Gómez",
            faculty = "Universidad Nacional de La Matanza",
            rating = "4.5",
            image = painterResource(R.drawable.martin),
            pricePerHour = 5.000,
            subjects = listOf("Economía General", "Química"),
            isTop = false
        ),
        Tutor(
            name = "Elena Rossi",
            faculty = "Universidad Nacional de La Matanza",
            rating = "4.0",
            image = painterResource(R.drawable.elena),
            pricePerHour = 5.700,
            subjects = listOf("Análisis Matemático", "Programación"),
            isTop = false
        )
    )

    val categorias = listOf("Todos", "Cálculo II","Análisis Matemático", "Física I", "Química General", "Programación")
    var categoriaSeleccionada by remember { mutableStateOf("Todos") }
    var searchQuery by remember { mutableStateOf("") }



        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAFAFA)),
            contentPadding = PaddingValues()
        ) {

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

            item {
                Row(Modifier.padding(horizontal = 26.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AccountBalance, contentDescription = null, Modifier.size(12.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Filtrado por: ", color = Color.Gray,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Text("Universidad Nacional de la Matanza",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold)
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
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 4.dp,
                        bottom = 8.dp
                    )
                )
            }

            item{
                FilterChip(
                    selected = false, // Mantiene el color de fondo activo para destacar
                    onClick = { /* Comportamiento estático para el prototipo visual */ },
                    label = {
                        Text(
                            text = "Ordenado por",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown, // Ícono de flecha hacia abajo
                            contentDescription = "Opciones de ordenamiento",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    },
                    shape = RoundedCornerShape(14.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        // Azul institucional con opacidad sutil para el fondo
                        containerColor = Color.Transparent,
                        selectedLabelColor = Color(0xFF0C56D1),
                        selectedTrailingIconColor = Color(0xFF0C56D1),
                        labelColor = Color.DarkGray
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = true,
                        borderColor = Color.LightGray.copy(alpha = 0.5f),
                        selectedBorderColor = Color.Transparent,
                        borderWidth = 1.dp
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            // 4. LISTA DE TUTORES (Contenido dinámico que ya tenías)
            items(profesoresFrecuentes) { tutor ->
                TutorCard(
                    tutor = tutor,
                    onReservarClick = onNavigateToProfile,
                    modifier = Modifier.padding(horizontal = 4.dp) // Ajuste fino de margen
                )
            }
        }
    }



@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        onNavigateToProfile = {}
    )
}