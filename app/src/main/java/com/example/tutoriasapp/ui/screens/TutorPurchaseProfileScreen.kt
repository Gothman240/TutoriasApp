package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import com.example.tutoriasapp.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutoriasapp.ui.components.ReviewCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorProfileScreen() {
    Scaffold(
        bottomBar = {
            // --- BARRA INFERIOR DE COMPRA ---
            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 8.dp,
                shadowElevation = 16.dp,
                color = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween, // Separa al máximo el precio del botón
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Sección del Precio
                    Column {
                        Text(
                            text = "Precio/hora",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray
                        )
                        Text(
                            text = "$4.500",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1D1B20)
                            )
                        )
                    }

                    // Botón de Reserva (Limpio, sin ícono y bordes corregidos)
                    Button(
                        onClick = { /* Acción de Reserva */ },
                        modifier = Modifier
                            .height(44.dp)
                            .width(180.dp), // Ancho fijo para que no compita y se mantenga elegante
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0C56D1), // Fondo azul con transparencia
                            //contentColor = Color(0xFF0C56D1) // Texto en azul pleno para que resalte
                        )
                    ) {
                        Text(
                            text = "Reservar",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        // --- CUERPO SCROLLABLE DE LA PANTALLA ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFFDFBFF)) // Fondo sutil claro
                .verticalScroll(rememberScrollState()) // Permite deslizar si la pantalla es chica
                .padding(24.dp)
        ) {

            // Cabecera: Foto del Tutor
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background), // Cambiar por tu foto
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(110.dp)
                        .border(3.dp, Color(0xFFE8DEF8), shape = CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre y Título del Tutor
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Dr. Alejandro Ruiz",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF1D1B20)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    SuggestionChip(
                        onClick = { },
                        label = { Text("Catedrático") }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "•  Universidad Nacional",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bloques de Información Básica (Grado / Experiencia)
            // --- Reemplaza el bloque de Grado y Experiencia por este ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // TARJETA: GRADO
                Card(
                    modifier = Modifier.weight(1f),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0C56D1).copy(alpha = .1f))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth() // Obliga a la columna a ocupar todo el ancho interno de la tarjeta
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally, // <--- Centra los elementos de la columna
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("🎓", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Grado en",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray,
                            textAlign = TextAlign.Center // <--- Centra el texto en sí mismo
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Física Avanzada",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color(0xFF211F24),
                            textAlign = TextAlign.Center // <--- Centra el texto en sí mismo si quiebra en dos líneas
                        )
                    }
                }

                // TARJETA: EXPERIENCIA
                Card(
                    modifier = Modifier.weight(1f),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0C56D1).copy(alpha = .1f))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth() // Obliga a la columna a ocupar todo el ancho interno de la tarjeta
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally, // <--- Centra los elementos de la columna
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("⏱️", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Experiencia",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "5+ Años",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color(0xFF211F24),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sección Materias (Usando FilterChips de Material 3)
            Text("Materias", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(8.dp))

            // Layout fluido simple usando filas para simular los tags
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF0C56D1).copy(alpha = 0.1f),
                    selectedLabelColor = Color(0xFF0C56D1) // Opcional: cambia el color del texto cuando se selecciona para que combine
                ), selected = true, onClick = {}, label = { Text("Cálculo II") })
                FilterChip(selected = false, onClick = {}, label = { Text("Mecánica Cuántica") })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(selected = false, onClick = {}, label = { Text("Álgebra Lineal") })
                FilterChip(selected = false, onClick = {}, label = { Text("Termodinámica") })
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sección Biografía
            Text("Biografía", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(8.dp))
            /*Text(
                text = "Apasionado por desmitificar las ciencias exactas. Mi metodología se centra en la resolución de problemas reales y el fortalecimiento de la base conceptual. Graduado con honores de la Universidad Politécnica.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF49454F),
                lineHeight = 22.sp
            )*/

            Spacer(modifier = Modifier.height(24.dp))

            // Sección Reseñas de Alumnos
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Reseñas de Alumnos", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                TextButton(onClick = { /* Ver todas */ }) {
                    Text("Ver todas", style = MaterialTheme.typography.labelLarge)
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Invocamos tu componente hardcodeado 2 veces consecutivas
            ReviewCard()
            ReviewCard()
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TutorProfileScreenPreview(){
    TutorProfileScreen()
}