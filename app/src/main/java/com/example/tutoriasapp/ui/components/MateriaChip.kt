package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MateriaChip(
    name: String,
    isSelected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        selected = isSelected,
        onClick = { onSelectedChange(!isSelected) },
        label = {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
        },
        // Icono de check (✓) solo cuando está seleccionado
        leadingIcon = if (isSelected) {
            {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Seleccionado",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                )
            }
        } else null,
        colors = FilterChipDefaults.filterChipColors(
            // Estado Seleccionado (Azul tonal suave)
            selectedContainerColor = Color(236,242,251),
            selectedLabelColor = Color(12,86,209),
            selectedLeadingIconColor = Color(12,86,209),

            // Estado No Seleccionado (Borde sutil gris)
            containerColor = Color(225,226,236).copy(alpha = .6f),
            labelColor = Color(67,70,84),

        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = isSelected,
            selectedBorderColor = Color(12,86,209), // Sin borde tosco al seleccionar
            selectedBorderWidth = 1.dp,
            disabledSelectedBorderColor = Color.Transparent,
            borderWidth = 0.dp
        ),
        shape = CardDefaults.shape // Mantiene las esquinas redondeadas en sintonía con tus tarjetas
    )
}