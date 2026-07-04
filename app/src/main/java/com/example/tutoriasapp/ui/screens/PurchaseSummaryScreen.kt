package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutoriasapp.R
import com.example.tutoriasapp.ui.components.TutorCardPurchase
import com.example.tutoriasapp.ui.theme.TutoriasAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchaseSummaryScreen(onNavigateToSuccess: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resumen de Reserva", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)) },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent, // Al ser transparente, absorbe el gradiente del fondo
                    scrolledContainerColor = Color.Transparent // Por si scrolleas, que no cambie de color
                )
            )
        },
        bottomBar = {
            // --- BOTÓN INFERIOR: CONFIRMAR Y PAGAR ---
            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 4.dp,
                color = Color.White
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    Button(
                        onClick = { onNavigateToSuccess() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0C56D1)//.copy(alpha = 0.2f), // Azul tonal deslavado de la imagen
                            //contentColor = Color(0xFF0C56D1)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(Icons.Default.Lock, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Confirmar y Pagar",
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        // Fondo gradiente unificado
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(250,248,255))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {

                // 1. TU COMPONENTE ORIGINAL (Contiene Tutor + Fecha + Hora en tu diseño)
                TutorCardPurchase(monto = "$4,500")

                Spacer(modifier = Modifier.height(36.dp))

                // 2. SECCIÓN: MÉTODO DE PAGO
                Text(
                    text = "Método de Pago",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF1D1B20)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Opción Seleccionada: Mercado Pago
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, Color(0xFF0C56D1), RoundedCornerShape(12.dp)), // Borde azul de selección
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Icono simulado de Mercado Pago (puedes cambiarlo por tu drawable si tenés)
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0,65,152),RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(painter = painterResource(R.drawable.outline_credit_card_24),
                                contentDescription = null,
                                tint = Color.White)
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Mercado Pago", fontWeight = FontWeight.Bold, color = Color(0xFF1D1B20))
                            Text(text = "Pago rápido y seguro", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold, color = Color.Gray)
                        }

                        // Radio Button Simulado encendido
                        RadioButton(selected = true, onClick = {}, colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF0C56D1)))
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // 3. MENSAJE INFORMATIVO DE REDIRECCIÓN
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0C56D1).copy(alpha = 0.05f)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_info_24),
                            contentDescription = null,
                            tint = Color(0,65,152),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Serás redirigido a la aplicación de Mercado Pago para completar el pago de forma segura.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. TARJETA RESUMEN DE COSTOS TOTALES
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(237,237,247)),
                    border = BorderStroke(1.dp, color = Color(195,198,213))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Clase virtual de 1 hora", fontWeight = FontWeight.SemiBold, color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
                            Text(text = "$4.500", fontWeight = FontWeight.SemiBold, color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
                        }

                        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), color = Color.Gray.copy(alpha = 0.4f))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Total", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                            Text(
                                text = "$5.000 ARS",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                color = Color(0,65,152)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Texto de Políticas legal hardcodeado
                        val legalText = buildAnnotatedString {
                            append("Al confirmar, aceptas nuestras ")
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = Color(0xFF0C56D1))) {
                                append("Políticas de Cancelación")
                            }
                            append(" y Términos de Servicio.")
                        }
                        Text(
                            text = legalText,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PurchaseSummaryScreenPreview() {
    TutoriasAppTheme {
        PurchaseSummaryScreen(
            onNavigateToSuccess = {}
        )
    }
}