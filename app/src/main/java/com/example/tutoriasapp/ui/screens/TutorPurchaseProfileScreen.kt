package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import com.example.tutoriasapp.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutoriasapp.ui.components.ReviewCard
import com.example.tutoriasapp.ui.components.SubjectChip

@OptIn(ExperimentalMaterial3Api::class, org.jetbrains.annotations.ApiStatus.Internal::class)
@Composable
fun TutorProfileScreen() {
    // --- ESTADO LOCAL PARA LA CHANCHADA INTERACTIVA ---
    var horasContratadas by remember { mutableStateOf(1) }
    val precioBase = 4500
    val precioTotal = precioBase * horasContratadas

    Scaffold(
        bottomBar = {
            // --- BARRA INFERIOR REESTRUCTURADA EN VERTICAL ---
            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 8.dp,
                shadowElevation = 16.dp,
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp) // Espaciado parejo vertical
                ) {

                    // 1. Selector de Horas y Texto de Precio
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Precio total ($horasContratadas ${if (horasContratadas == 1) "hora" else "horas"})",
                                style = MaterialTheme.typography.labelSmall,
                                //color = Color.Gray
                            )
                            Text(
                                text = "$$precioTotal", // Se actualiza automáticamente al multiplicar
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1D1B20)
                                )
                            )
                        }

                        // Controlador dinámico para sumar y restar horas
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            IconButton(
                                onClick = { if (horasContratadas > 1) horasContratadas-- },
                                modifier = Modifier.size(32.dp).background(Color(0xFFF3F3FA), CircleShape)
                            ) {
                                Icon(Icons.Default.Remove, contentDescription = "Restar hora", modifier = Modifier.size(16.dp))
                            }

                            Text(
                                text = "$horasContratadas",
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )

                            IconButton(
                                onClick = { if (horasContratadas < 5) horasContratadas++ }, // Límite de 5 para la demo
                                modifier = Modifier.size(32.dp).background(Color(0xFFF3F3FA), CircleShape)
                            ) {
                                Icon(Icons.Default.Add, contentDescription = "Sumar hora", modifier = Modifier.size(16.dp))
                            }
                        }
                    }

                    // 2. Botón de Reserva abajo de todo ocupando el ancho completo
                    Button(
                        onClick = { /* Acción de Reserva */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0C56D1)
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    brush = Brush.linearGradient(
                        0.0f to Color(234, 238, 253),
                        1.0f to Color(250, 249, 255),
                        start = Offset(x = 0f, y = 0f),
                        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp)
            ) {

                // Cabecera: Foto del Tutor
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(110.dp)
                            .border(3.dp, Color(0xFF0C56D1).copy(alpha = 0.2f), shape = CircleShape)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Nombre y Sección de Valoración
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Alejandro Ruiz",
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(0xFF1D1B20)
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Valoración",
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "4.7",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color(0xFF1D1B20)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "•  Universidad Nacional de La Matanza",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Bloques de Información Básica
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Card(
                        modifier = Modifier.weight(1f),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF0C56D1).copy(alpha = .08f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.study),
                                contentDescription = null,
                                tint = Color(0xFF0C56D1),
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Graduado en",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Gray,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Ingeniería Civil",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                color = Color(0xFF211F24),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Card(
                        modifier = Modifier.weight(1f),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF0C56D1).copy(alpha = .08f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Schedule,
                                contentDescription = null,
                                tint = Color(0xFF0C56D1),
                                modifier = Modifier.size(24.dp)
                            )
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

                // Sección Materias
                Text("Materias", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(12.dp))

                Box(modifier = Modifier.fillMaxWidth()) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SubjectChip(name = "Cálculo II", isSelected = true, onSelectionChanged = {})
                        SubjectChip(name = "Probabilidad y Estadística", isSelected = false, onSelectionChanged = {})
                        SubjectChip(name = "Álgebra Lineal", isSelected = false, onSelectionChanged = {})
                        SubjectChip(name = "Cálculo Númerico", isSelected = false, onSelectionChanged = {})
                    }

                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .clickable(
                                onClick = {},
                                enabled = false,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            )
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Sección Reseñas
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

                ReviewCard()
                ReviewCard()
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TutorProfileScreenPreview() {
    TutorProfileScreen()
}