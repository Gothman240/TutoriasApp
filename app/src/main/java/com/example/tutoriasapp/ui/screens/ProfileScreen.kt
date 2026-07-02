package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutoriasapp.R
import com.example.tutoriasapp.ui.theme.TutoriasAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentProfileScreen() {
    Scaffold { innerPadding ->
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
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // 1. FOTO DE PERFIL SIN BORDE AZUL GRUESO + BOTÓN EDITAR FLOTANTE
                Box(
                    modifier = Modifier.size(110.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background), // Tu avatar real de Mateo
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(110.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    // Lapicito flotador de edición de foto (Estilo la captura)
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color(0xFFBA3200), CircleShape), // Color naranja quemado
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar foto",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 2. INFORMACIÓN DEL ESTUDIANTE REFACTORIZADA
                Text(
                    text = "Mateo García",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF1D1B20)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Ingeniería Civil", // Modificado
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Universidad Nacional de La Matanza", // Modificado y sin 4to Semestre
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                // 3. TARJETAS DE ESTADÍSTICAS REFACTORIZADAS Y ALINEADAS (Matriz de 2x2 Simétrica)
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // FILA 1: Tutorías y Horas de Estudio
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Card 1: Clases
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp, horizontal = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "12",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0C56D1)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Tutorías tomadas", // Texto optimizado
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        // Card 2: Horas Totales
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp, horizontal = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "36hs",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0C56D1)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "De estudio",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    // FILA 2: Reseñas Dejadas y Materias Solicitadas
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Card 3: Reseñas
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp, horizontal = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "8",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0C56D1)
                                ) // Corregido a color azul de la app
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Reseñas escritas",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        // Card 4: MATERIAS CON TEXTO EXPLICATIVO DE SELECCIÓN
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp, horizontal = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "5",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0C56D1)
                                ) // Corregido a color azul de la app
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Materias asistidas", // Se entiende perfectamente que son las asignaturas donde buscó ayuda
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. NUEVA SECCIÓN: BIOGRAFÍA EDITABLE CON LÁPIZ (No funcional)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Sobre mí",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = Color(0xFF1D1B20)
                            )
                            // Icono de lapicito sutil para editar biografía
                            IconButton(onClick = {}, modifier = Modifier.size(24.dp)) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Editar biografía",
                                    tint = Color.Gray,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Estudiante de Ingeniería enfocado en el área estructural. Uso las tutorías principalmente para reforzar materias avanzadas como Cálculo Numérico e Hidrología.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF49454F),
                            lineHeight = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. SECCIÓN: ACTIVIDAD RECIENTE
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Actividad Reciente",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(0xFF1D1B20)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color(0xFF0C56D1).copy(alpha = 0.1f), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Payments, null, tint = Color(0xFF0C56D1))
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "Pago confirmado",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "Clase de Física con Elena M.",
                                    color = Color.Gray,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }

                        Text(
                            text = "Ayer",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun StudentProfileScreenPreview() {
    TutoriasAppTheme {
        StudentProfileScreen()
    }
}