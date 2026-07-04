package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
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
    selectedDateText: String,
    selectedTime: String?,
    modifier: Modifier = Modifier,
) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Columna de textos explicativos
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "TU SESIÓN",
                    style = MaterialTheme.typography.labelSmall.copy(
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = Color(0xFF434565) // Un azul oscuro sutil para el tag superior
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "$selectedDateText • $selectedTime hs",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFF191A2C) // Texto principal más oscuro para legibilidad
                )
            }

            // Ícono de calendario de Material 3 a la derecha
            Icon(
                imageVector = Icons.Outlined.CalendarToday,
                contentDescription = "Fecha seleccionada",
                modifier = Modifier.size(22.dp),
                tint = Color(76,94,139)
            )
        }
    }


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ClassSummaryCardPreview() {
    ClassSummaryCard(
        selectedDateText = "Miércoles, 8 de Mayo",
        selectedTime = "14:00"
    )
}