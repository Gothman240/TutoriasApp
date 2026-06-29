package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutoriasapp.ui.components.ClassSummaryCard
import com.example.tutoriasapp.ui.components.TutorCardSelected
import java.util.Calendar

// --- FUNCIÓN PREVIEW PARA VERLA EN ANDROID STUDIO ---
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DateTimePurchaseScreenPreview() {
    DateTimePurchaseScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimePurchaseScreen() {
    // Estado nativo del calendario de Material 3
    val customSelectableDates = remember {
        object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                // Obtener la fecha actual a la medianoche (en milisegundos)
                val todayMillis = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, 0)
                    set(Calendar.MINUTE, 0)
                    set(Calendar.SECOND, 0)
                    set(Calendar.MILLISECOND, 0)
                }.timeInMillis

                // Regla 1: Bloquear días pasados
                if (utcTimeMillis < todayMillis) return false

                // Regla 2: Bloquear fines de semana (Opcional, bórralo si no lo necesitas)
                val calendar = Calendar.getInstance().apply {
                    timeInMillis = utcTimeMillis
                }
                val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

                // Calendar.SATURDAY es 7 y Calendar.SUNDAY es 1
                return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY
            }
        }
    }

    val datePickerState = rememberDatePickerState(
        selectableDates = customSelectableDates
    )
    Scaffold(
        bottomBar = {
            // --- BARRA INFERIOR: BOTÓN CONTINUAR ---
            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 8.dp,
                color = Color.White
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { /* Truco: Pon acá un log o la navegación directa */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0C56D1)/*.copy(alpha = 0.1f)*/,
                            //contentColor = Color(0xFF0C56D1)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Continuar",
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFFDFBFF))
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            // 1. Cabecera (Tu componente visual previo)
            TutorCardSelected()

            //Spacer(modifier = Modifier.height(14.dp))

            // Textos informativos
            Text(
                text = "Selecciona fecha y hora",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFF1D1B20)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Elige el momento que mejor se adapte a tu horario académico.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 2. Calendario de Material 3 empotrado en una tarjeta blanca
            Box(
                modifier = Modifier
                    // 2. Le damos tu elevación y bordes redondeados idénticos a las tarjetas
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(28.dp),
                        clip = true // Corta el calendario para que herede las esquinas redondeadas
                    )
                    .background(Color.White, shape = RoundedCornerShape(28.dp))
                    .padding(paddingValues = PaddingValues(bottom = 12.dp))
            ) {
                // 3. El componente nativo de calendario
                MaterialTheme(
                    typography = MaterialTheme.typography.copy(
                        // Achica el tamaño de los números de los días y las celdas
                        bodyMedium = MaterialTheme.typography.bodyMedium.copy(fontSize = 13.sp),
                        // Achica la barra superior donde dice el mes y año
                        headlineLarge = MaterialTheme.typography.headlineLarge.copy(fontSize = 14.sp)
                    )
                ) {
                    DatePicker(
                        state = datePickerState,
                        title = null,       // Ocultamos el título por defecto de Material para ahorrar espacio
                        headline = null,    // Ocultamos la fecha gigante seleccionada arriba
                        showModeToggle = false, // Quitamos el icono de lápiz para cambiar a modo texto (look más limpio)
                        colors = DatePickerDefaults.colors(
                            containerColor = Color.White,
                            // Color del círculo del día seleccionado (Tu azul #0C56D1)
                            selectedDayContainerColor = Color(0xFF0C56D1),
                            selectedDayContentColor = Color.White,
                            // Color del día de hoy
                            todayContentColor = Color(0xFF0C56D1),
                            todayDateBorderColor = Color(0xFF0C56D1),
                            // Flechas para cambiar de mes
                            navigationContentColor = Color(0xFF0C56D1)
                        ),
                    )
                }
            }


            Spacer(modifier = Modifier.height(12.dp))

            // 3. Grilla de Horarios Directos
            Text(
                text = "Horas disponibles",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFF1D1B20)
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Fila de Horarios 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TimeSlotButtonHardcoded(
                    text = "09:00 AM",
                    isSelected = false,
                    isEnabled = true,
                    modifier = Modifier.weight(1f)
                )
                TimeSlotButtonHardcoded(
                    text = "10:30 AM",
                    isSelected = false,
                    isEnabled = true,
                    modifier = Modifier.weight(1f)
                )
                TimeSlotButtonHardcoded(
                    text = "12:00 PM",
                    isSelected = false,
                    isEnabled = false,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Fila de Horarios 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TimeSlotButtonHardcoded(
                    text = "02:00 PM",
                    isSelected = true,
                    isEnabled = true,
                    modifier = Modifier.weight(1f)
                )
                TimeSlotButtonHardcoded(
                    text = "03:30 PM",
                    isSelected = false,
                    isEnabled = true,
                    modifier = Modifier.weight(1f)
                )
                TimeSlotButtonHardcoded(
                    text = "05:00 PM",
                    isSelected = false,
                    isEnabled = true,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 4. Tu resumen hardcodeado directo para la demo
            ClassSummaryCard(/*bookingInfo = "Miércoles, 8 de Mayo • 02:00 PM"*/)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TimeSlotButtonHardcoded(
    text: String,
    isSelected: Boolean,
    isEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    val containerColor = when {
        !isEnabled -> Color(0xFFF1F3F9)
        isSelected -> Color(0xFF0C56D1) // Fondo azul pleno si está elegido
        else -> Color.White
    }

    val contentColor = when {
        !isEnabled -> Color.LightGray
        isSelected -> Color.White
        else -> Color(0xFF0C56D1)
    }

    val borderStroke = if (!isSelected && isEnabled) {
        //ButtonDefaults.outlinedButtonColors().border
    } else null

    Button(
        onClick = {},
        enabled = isEnabled,
        modifier = modifier.height(40.dp),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor
        ),
        //border = borderStroke
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
            // Si está deshabilitado le metemos un tachado visual simple
            textDecoration = if (!isEnabled) androidx.compose.ui.text.style.TextDecoration.LineThrough else null
        )
    }
}