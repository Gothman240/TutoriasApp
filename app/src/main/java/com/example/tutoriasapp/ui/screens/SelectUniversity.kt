package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutoriasapp.R
import com.example.tutoriasapp.ui.components.UniversityCard

@Composable
fun SelectUniversity(navigateSelectSubjectScreen: () -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    0.0f to Color(234, 238, 253),
                    1.0f to Color(250, 249, 255),
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = 0f, y = Float.POSITIVE_INFINITY)
                )
            )
    ) {
        Column(Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 36.dp)
            .verticalScroll(rememberScrollState())) {
            Spacer(Modifier.height(46.dp))
            Text("Cuentanos sobre tu universidad", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Esto nos ayuda a conectarte con tutores de tu misma institución.",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp),
                placeholder = {
                    Text(
                        text = "Buscar tu universidad...",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color(0xFF0C56D1)
                    )
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF0C56D1),
                    unfocusedBorderColor = Color.LightGray,  
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
            )
            Spacer(Modifier.height(8.dp))
            Text("Sugerido cerca de ti", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(16.dp))
            UniversityCard(name = "Universidad de Buenos Aires", location = "CABA, Buenos Aires") { navigateSelectSubjectScreen() }
            UniversityCard(name = "Universidad Tecnológica Nacional (UTN)", location = "Avellaneda, Buenos Aires") { navigateSelectSubjectScreen() }
            UniversityCard(name = "Universidad Nacional de Quilmes (UNQ)", location = "Quilmes, Buenos Aires") { navigateSelectSubjectScreen() }
            UniversityCard(name = "Universidad Nacional de La Matanza", location = "San Justo, Buenos Aires") { navigateSelectSubjectScreen() }
            UniversityCard(name = "Universidad Nacional de General San Martín (UNSAM)", location = "San Martín, Buenos Aires") { navigateSelectSubjectScreen() }
            Spacer(modifier = Modifier.height(90.dp))
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .drawWithContent {
                    drawContent()
                    drawLine(
                        color = Color.LightGray.copy(alpha = 0.5f),
                        start = Offset(x = 0f, y = 0f),
                        end = Offset(x = size.width, y = 0f),
                        strokeWidth = 1.dp.toPx()
                    )
                }, color = Color.White
        ) {
            Button(
                onClick = { navigateSelectSubjectScreen() },
                enabled = searchQuery.isNotEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(12,86,208))
            ) {
                Text("Continuar", style = MaterialTheme.typography.titleMedium, color = Color.White)
                Spacer(Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.round_chevron_right_24),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SelectUniversityPreview(){
    SelectUniversity(navigateSelectSubjectScreen =  {})
}