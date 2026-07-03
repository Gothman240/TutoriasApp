package com.example.tutoriasapp.ui.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
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
fun TutoriasScreen() {

        // Fondo gradiente que ahora ocupa el 100% real de la pantalla
        Box(
            modifier = Modifier
                .fillMaxSize()
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
                    .padding(horizontal = 20.dp, vertical = 24.dp) // Un poco más de aire arriba
            ) {

                // ==========================================
                // CABECERA INTEGRADA EN EL SCROLL
                // ==========================================
                Text(
                    text = "Mis Tutorías",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF1D1B20)
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Gestiona tus próximas clases virtuales",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray,
                )

                Spacer(modifier = Modifier.height(28.dp))

                // ==========================================
                // 1. SECCIÓN: PRÓXIMA CLASE
                // ==========================================
                Text(
                    text = "PRÓXIMA CLASE",
                    style = MaterialTheme.typography.labelMedium.copy(letterSpacing = 1.2.sp),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(89,123,197)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.ic_launcher_background),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(74.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = "Alejandro Ruiz",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "Cálculo II",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(73,95,155)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(243,243,253)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 18.dp).fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text("FECHA",
                                        style = MaterialTheme.typography.labelMedium.copy(letterSpacing = 1.2.sp),
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.Gray)
                                    Spacer(Modifier.height(4.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.CalendarMonth, null, tint = Color(41,36,46), modifier = Modifier.size(18.dp))
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("15 de Octubre", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                                    }
                                }
                                Column() {
                                    Text("HORARIO",
                                        style = MaterialTheme.typography.labelMedium.copy(letterSpacing = 1.2.sp),
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.Gray)
                                    Spacer(Modifier.height(4.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.Schedule, null, tint = Color(41,36,46), modifier = Modifier.size(18.dp))
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("16:00 - 17:00", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier.weight(1f).height(40.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(12,86,209), contentColor = Color.White)
                            ) {
                                Text("Modificar", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            }
                            OutlinedButton(
                                onClick = {},
                                modifier = Modifier.weight(1f).height(40.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFBA3200)),
                                border = ButtonDefaults.outlinedButtonBorder
                                    .copy(brush = Brush.linearGradient(listOf(Color(0xFFBA3200).copy(alpha = 0.5f), Color(0xFFBA3200).copy(alpha = 0.5f))))
                            ) {
                                Text("Cancelar", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // ==========================================
                // 2. SECCIÓN: OTRAS RESERVAS
                // ==========================================
                Text(
                    text = "OTRAS RESERVAS",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.ExtraBold, letterSpacing = 1.2.sp),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(10.dp))

                val otrasReservas = listOf(
                    Pair("Ricardo Sosa", "Hidrología Aplicada" to "18 Oct \n10:00 AM"),
                    Pair("Ana García", "Geotécnica" to "22 Oct \n15:30 PM")
                )

                otrasReservas.forEach { (tutor, datos) ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(14.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        modifier = Modifier.size(44.dp).clip(CircleShape)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Text(tutor, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                                        Text(datos.first,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.Gray,
                                            style = MaterialTheme.typography.bodySmall)
                                    }
                                }
                                Text(
                                    text = datos.second,
                                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                                    color = Color(94,99,108),
                                    textAlign = TextAlign.End
                                )
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextButton(
                                    modifier = Modifier.weight(1f).height(32.dp),
                                    onClick = {},
                                    colors = ButtonDefaults.textButtonColors(containerColor = Color(10,87,207).copy(alpha = .1f)),
                                    shape = RoundedCornerShape(6.dp),
                                ) {
                                    Text("Modificar", fontSize = 13.sp, color = Color(67,87,106), fontWeight = FontWeight.SemiBold)
                                }
                                Spacer(Modifier.width(8.dp))
                                TextButton(onClick = {},
                                    modifier = Modifier.height(32.dp).weight(.4f),
                                    colors = ButtonDefaults.textButtonColors(containerColor = Color(0xFFBA3200).copy(alpha = .1f)),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text("Cancelar", fontSize = 13.sp, color = Color(0xFFBA3200), fontWeight = FontWeight.SemiBold)
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // ==========================================
                // 3. SECCIÓN: CLASES VIRTUALES TOMADAS
                // ==========================================
                Text(
                    text = "CLASES VIRTUALES TOMADAS",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.ExtraBold, letterSpacing = 1.2.sp),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(14.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier.size(44.dp).background(Color(0xFF0C56D1).copy(alpha = 0.1f), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Person, null, tint = Color(0xFF0C56D1))
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Elena Martínez", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                                Text("Ingeniería Legal", fontWeight = FontWeight.SemiBold,
                                    color = Color.Gray,
                                    style = MaterialTheme.typography.bodySmall)
                            }
                        }

                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0C56D1)),
                            modifier = Modifier.height(36.dp)
                        ) {
                            Text("Dejar reseña", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TutoriasScreenPreview() {
    TutoriasAppTheme {
        TutoriasScreen()
    }
}