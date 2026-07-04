package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.sp
import com.example.tutoriasapp.R
import com.example.tutoriasapp.ui.components.TutorCardPurchase
import com.example.tutoriasapp.ui.theme.TutoriasAppTheme

@Composable
fun SuccessPurchaseScreen() {
    Scaffold(
        bottomBar = {
            // --- BOTÓN INFERIOR: IR A TUTORÍAS ---
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
                        onClick = { /* Navegar a la sección de tutorías programadas */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp), // Totalmente redondeado como la imagen
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0C56D1)//.copy(alpha = 0.2f), // Azul tonal deslavado de la imagen
                            //contentColor = Color(0xFF0C56D1)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Ir a tutorías", // Tu cambio solicitado
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            // Icono de flecha hacia la derecha
                            Icon(
                                painter = painterResource(id = R.drawable.round_chevron_right_24),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
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
                .background(
                    brush = Brush.linearGradient(
                        0.0f to Color(250,249,255),
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
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                // 1. ICONO DE ÉXITO CIRCULAR GRANDE
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .background(Color(0xFF0C56D1).copy(alpha = 0.15f), CircleShape), // Círculo deslavado de fondo
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Éxito",
                        tint = Color(0xFF0C56D1), // Azul de tu paleta
                        modifier = Modifier.size(64.dp)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. TEXTOS DE CONFIRMACIÓN
                Text(
                    text = "¡Reserva Exitosa!",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    //color = Color(0xFF0C56D1),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Tu sesión ha sido confirmada. Alejandro te espera.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF1D1B20),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                // 3. TU COMPONENTE ORIGINAL (Reutiliza tus tarjetas, fecha y hora de forma compacta)
                TutorCardPurchase()

                Spacer(modifier = Modifier.weight(1f))

                // 4. SECCIÓN: CONTACTO DIRECTO WHATSAPP
                Text(
                    text = "CONTACTO DIRECTO",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    ),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(18.dp))

                OutlinedButton(
                    onClick = { /* Simular abrir WhatsApp web/app */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF0C56D1)), // Verde WhatsApp
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        // Puedes usar un emoji de chat o un ícono si tenés el svg de whatsapp
                        Icon(
                            painter = painterResource(id = R.drawable.whatsapp),
                            contentDescription = null,
                            tint = Color(0xFF25D366),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "WhatsApp",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color(0xFF1D1B20)
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SuccessPurchaseScreenPreview() {
    TutoriasAppTheme {
        SuccessPurchaseScreen()
    }
}