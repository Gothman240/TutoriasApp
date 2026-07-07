package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.tutoriasapp.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TutorCardSelected(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            /*.padding(/*horizontal = 16.dp, vertical = */6.dp)*/,
        colors = CardDefaults.cardColors(
            containerColor = Color(255,255,255),
        ),
        border = BorderStroke(1.dp, color = Color(195,198,213)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 1. Imagen de perfil con esquinas redondeadas suaves
            Image(
                painter = painterResource(R.drawable.ic_launcher_background), // Cambiar por tu imagen de tutor
                contentDescription = "Foto del tutor",
                modifier = Modifier
                    .size(86.dp)
                    .clip(RoundedCornerShape(14.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // 2. Columna central con Nombre, Materia y la Píldora de Precio
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                // Fila del Nombre + Icono de verificado
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Alejandro Ruiz",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,

                        )
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                // Materia secundaria
                Text(
                    text = "Cálculo II",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(75,104,172)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // 3. Píldora de Precio más grande (Con tus colores personalizados)
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0,65,152),
                            shape = CircleShape
                        )
                        .padding(horizontal = 10.dp, vertical = 4.dp), // Padding más amplio para hacerla más grande
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$4.500/hr",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White, // Tu azul pleno
                            fontSize = 14.sp // Un punto más grande que la escala común
                        )
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TutorCardSelectedPreview(){
    TutorCardSelected()
}