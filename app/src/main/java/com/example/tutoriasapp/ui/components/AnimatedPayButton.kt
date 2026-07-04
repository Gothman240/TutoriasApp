package com.example.tutoriasapp.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun AnimatedPayButton(onNavigateToSuccess: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()

    // El progreso va de 0.0f (todo azul) a 1.0f (todo verde)
    val progress = remember { Animatable(0f) }

    // Definimos los colores del diseño
    val azulColor = Color(0xFF0C56D1)
    val verdeColor = Color(0xFF10B981) // Un verde vibrante estilo Material

    // Creamos el degradado dinámico basado en el progreso de la animación
    val brush = remember(progress.value) {
        if (progress.value == 0f) {
            // Estado inicial estático: 100% azul
            Brush.linearGradient(listOf(azulColor, azulColor))
        } else {
            // Estado en movimiento: el frente verde avanza empujando al azul
            Brush.linearGradient(
                0.0f to verdeColor,
                progress.value to verdeColor,
                (progress.value + 0.05f).coerceAtMost(1f) to azulColor,
                1.0f to azulColor
            )
        }
    }

    Button(
        onClick = {
            // Evitamos que el usuario haga múltiples clics si ya se está animando
            if (!progress.isRunning && progress.value == 0f) {
                coroutineScope.launch {
                    // Animación de 800 milisegundos de izquierda a derecha
                    progress.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(durationMillis = 2000)
                    )
                    // Una vez que llega a 1f, ejecuta la navegación
                    onNavigateToSuccess()
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            // IMPORTANTE: Aplicamos el fondo con el degradado usando el mismo shape del botón
            .background(brush, shape = RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        // Seteamos el containerColor a Transparent para que se vea el fondo .background() de arriba
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues() // Limpia paddings internos para que el fondo cubra todo
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

@Preview
@Composable
fun AnimatedPayButtonPrev(){
    AnimatedPayButton {  }
}