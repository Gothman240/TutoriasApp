package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutoriasapp.R
import com.example.tutoriasapp.ui.screens.Tutor

@Composable
fun TutorCard(
    tutor: Tutor,
    onReservarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.8f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. SECCIÓN IZQUIERDA: IMAGEN + BADGE "TOP"
            Box(
                modifier = Modifier.size(100.dp)
            ) {
                // Foto del tutor con bordes redondeados
                Image(
                    painter = tutor.image, // Cambia por tu recurso o AsyncImage de Coil
                    contentDescription = "Foto de ${tutor.name}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                )

                // Badge "TOP" arriba a la derecha de la foto
                if (tutor.isTop) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 6.dp, end = 6.dp)
                            .background(Color(0xFF7A3006), shape = RoundedCornerShape(6.dp)) // Marrón oscuro de la imagen
                            .padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle, // Puedes cambiarlo por un icono de estrella/certificado
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(10.dp)
                        )
                        Text(
                            text = "TOP",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }

            // 2. SECCIÓN DERECHA: INFORMACIÓN DETALLADA
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                // Fila de Nombre y Calificación (Rating)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = tutor.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color(0xFF0C56D1) // Tu azul característico
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    // Contenedor del Rating (Estrella + Número)
                    Row(
                        modifier = Modifier
                            .background(Color(218, 227, 254), shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(76,93,141), // Tu azul o dorado
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = tutor.rating,
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.ExtraBold),
                            color = Color(2,27,67)
                        )
                    }
                }

                // Facultad
                Text(
                    text = tutor.faculty,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                // Chips de las materias que dicta (usando FlowRow para que no se corten)
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    tutor.subjects.forEach { subject ->
                        Box(
                            modifier = Modifier
                                .background(Color(8,91,204).copy(alpha = .1f), shape = RoundedCornerShape(12.dp)) // Celeste ultra suave
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = subject,
                                style = MaterialTheme.typography.labelMedium.copy(fontSize = 11.sp),
                                color = Color(0,65,152)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                // Fila de Precio y Boton Reservar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Precio
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color(0, 65, 152)
                            )
                            ) {
                                append("$${String.format("%.3f", tutor.pricePerHour)}")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, color = Color.Gray)) {
                                append("/hr")
                            }
                        }
                    )

                    // Botón Reservar
                    Button(
                        onClick = onReservarClick,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(8,91,204)), // Azul pastel/atenuado
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        modifier = Modifier.height(36.dp)
                    ) {
                        Text(
                            text = "Reservar",
                            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}