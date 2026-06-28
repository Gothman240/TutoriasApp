package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutoriasapp.R

@Composable
fun TutorCardPurchase(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(9.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.size(90.dp)
                )
            }
            Column(Modifier.padding(8.dp)) {
                Row() {
                    Text(
                        modifier = Modifier.widthIn(2.dp),
                        text = "Alejandro Ruiz",
                        textAlign = TextAlign.Start
                    )

                }
                Spacer(modifier.padding(8.dp))
                Row() {
                    Text(
                        modifier = Modifier.widthIn(2.dp),
                        text = "Cálculo II",
                        textAlign = TextAlign.Start
                    )

                }
                Spacer(modifier.padding(12.dp))

                Row() {
                    Text(text = "$4.500")
                    Spacer(modifier.weight(1f))
                    Badge {
                        Text("Experto")
                    }
                }

            }

        }
        HorizontalDivider(thickness = 2.dp)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            colors = CardDefaults.outlinedCardColors()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "FECHA",
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "📅 15 de Octubre")
                    }
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "HORARIO",
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "🕒 16:00 - 17:30")
                    }
                }
            }

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TutorCardPurchasePreview() {
    TutorCardPurchase()
}