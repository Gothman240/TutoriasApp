package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SubjectChip(
    name: String,
    isSelected: Boolean,
    onSelectionChanged: (Boolean) -> Unit
) {
    FilterChip(
        selected = isSelected,
        onClick = { onSelectionChanged(!isSelected) },
        label = {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
            )
        },
        // Muestra el icono de "Visto/Check" solo si está seleccionado
        leadingIcon = if (isSelected) {
            {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
            }
        } else null,
        shape = RoundedCornerShape(12.dp),
        colors = FilterChipDefaults.filterChipColors(
            // Colores en estado de reposo (Desactivado)
            containerColor = Color.Transparent,
            labelColor = Color.DarkGray,
            // Colores cuando el alumno lo selecciona (Activado)
            selectedContainerColor = Color(0xFF0C56D1),
            selectedLabelColor = Color.White,
            selectedLeadingIconColor = Color.White
        ),
        border = BorderStroke(
            width = if (isSelected) 0.dp else 2.dp, // ⚠️ Cambia el grosor dinámicamente
            color = if (isSelected) Color.Transparent else Color.LightGray.copy(alpha = 0.5f)
        )
    )
}