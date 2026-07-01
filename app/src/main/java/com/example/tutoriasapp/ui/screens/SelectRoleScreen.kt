package com.example.tutoriasapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutoriasapp.R

@Composable
fun SelectRoleScreen(navigateToSelectUniversity: () -> Unit) {
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
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(46.dp))
            Text("Selecciona tu camino", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.padding(horizontal = 24.dp)){
                Text("Selecciona cómo desea utilizar TutorMe para personalizar su experiencia.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(Modifier.height(22.dp))
            Box(
                modifier = Modifier
                    .clickable(onClick = { navigateToSelectUniversity() })
                    .fillMaxWidth()
                    .shadow(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(36.dp),
                        clip = false
                    )
                    .background(Color.White, shape = RoundedCornerShape(36.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp, vertical = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = Color(0xFF0C56D1).copy(alpha = .1f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painterResource(R.drawable.study),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = Color(0xFF0C56D1)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Soy estudiante", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "Necesito apoyo académico y tutorías para sobresalir en mis clases.",
                        textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                }
                Box(
                    modifier = Modifier
                        .padding(bottom = 20.dp, end = 24.dp)
                        .size(32.dp)
                        .background(
                            color = Color(0xFF0C56D1).copy(alpha = .1f),
                            shape = CircleShape
                        )
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_chevron_right_24),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFF0C56D1)
                    )
                }
            }
            Spacer(Modifier.height(22.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(36.dp),
                        clip = false
                    )
                    .background(Color.White, shape = RoundedCornerShape(36.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp, vertical = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = Color(242, 107, 34).copy(alpha = .1f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painterResource(R.drawable.edu),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = Color(242, 107, 34)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Soy tutor", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "Quiero ayudar a otros, compartir conocimientos y ganar dinero mientras enseño.",
                        textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                }
                Box(
                    modifier = Modifier
                        .padding(bottom = 20.dp, end = 24.dp)
                        .size(32.dp)
                        .background(
                            color = Color(242, 107, 34).copy(alpha = .1f),
                            shape = CircleShape
                        )
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_chevron_right_24),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color(242, 107, 34)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SelectRoleScreenPreview(){
    SelectRoleScreen(navigateToSelectUniversity = {})
}