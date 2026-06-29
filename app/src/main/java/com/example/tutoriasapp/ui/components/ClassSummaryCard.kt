package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClassSummaryCard(
    //bookingInfo: String, // Ej: "Miércoles, 8 de Mayo • 02:00 PM"
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            /*.padding(16.dp)*/,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFDDE1FF) // El tono lila/azul suave de "Tu Sesión"
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Columna de textos explicativos
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "TU SESIÓN",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color(0xFF434565) // Un azul oscuro sutil para el tag superior
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Miércoles, 8 de Mayo • 14:00",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFF191A2C) // Texto principal más oscuro para legibilidad
                )
            }

            // Ícono de calendario de Material 3 a la derecha
            Icon(
                imageVector = Icons.Outlined.CalendarMonth,
                contentDescription = "Fecha seleccionada",
                modifier = Modifier.size(22.dp),
                tint = Color(0xFF434565)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClassSummaryCardPreview() {
    ClassSummaryCard()
}