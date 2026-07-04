package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.tutoriasapp.ui.screens.TimeSlot

@Composable
fun FlowRowScope.TimeButton(
    slot: TimeSlot,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    // Determinar los colores según el estado
    val backgroundColor = when {
        !slot.isAvailable -> Color(0xFFF5F5F7) // Gris claro
        isSelected -> Color(0xFF0047A3)       // Azul oscuro
        else -> Color.White
    }

    val contentColor = when {
        !slot.isAvailable -> Color(0xFFB0B0B5) // Texto tachado/gris
        isSelected -> Color.White
        else -> Color(0xFF0047A3)
    }

    val borderColor = if (isSelected || !slot.isAvailable) Color.Transparent else Color(0xFF0047A3)

    Surface(
        onClick = onClick,
        enabled = slot.isAvailable, // Si es falso, bloquea los clics automáticamente
        shape = RoundedCornerShape(12.dp),
        color = backgroundColor,
        contentColor = contentColor,
        border = if (borderColor != Color.Transparent) BorderStroke(1.dp, borderColor) else null,
        // Usamos weight(1f) para que los 3 botones ocupen el mismo ancho exacto por fila
        modifier = Modifier.weight(1f)
    ) {
        Box(
            modifier = Modifier.padding(vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = slot.time,
                fontWeight = FontWeight.Medium,
                // Aplicar tachado si no está disponible
                style = if (!slot.isAvailable) {
                    LocalTextStyle.current.copy(textDecoration = TextDecoration.LineThrough)
                } else {
                    LocalTextStyle.current
                }
            )
        }
    }
}